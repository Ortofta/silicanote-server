package org.silicanote.engine.dao;

import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.model.Attribute;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.Item;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.ReplaceableItem;
import com.amazonaws.services.simpledb.model.SelectRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.silicanote.model.db.DBNote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Markus Svensson
 */
public class NoteDaoAwsSimpleDbImpl implements NoteDao {

    private static final Logger logger = LoggerFactory.getLogger(NoteDaoAwsSimpleDbImpl.class);
    
    @Resource
    private AmazonSimpleDB sdbClient;
    
    @Resource
    private String domainName;

    public void createDomain(String domainName) {
        sdbClient.createDomain(new CreateDomainRequest(domainName));
    }

    @Override
    public DBNote getNote(String noteId) {
        String selectStatement = "select * from " + domainName + " where ItemName = '" + noteId + "'";
        SelectRequest request = new SelectRequest(selectStatement);
        List<DBNote> notes = new ArrayList<>();
        for(Item item : sdbClient.select(request).getItems()) {
            String heading = "";
            String body = "";
            List<Attribute> attributes = item.getAttributes();
            for(Attribute attribute : attributes) {
                switch (attribute.getName()) {
                    case "heading":
                        heading = attribute.getValue();
                        break;
                    case "body":
                        body = attribute.getValue();
                        break;
                    default:
                        logger.info("Unknown attribute: " + attribute.getName());
                }
            }
            DBNote note = new DBNote(item.getName(), heading, body);
            notes.add(note);
        }
        
        if(notes.size() > 1) {
            logger.error("More than one item with name: " + noteId + " was returned");
        }
        
        if(notes.isEmpty()) {
            return null;
        }else{ 
            return notes.get(0);
        }
    }

    @Override
    public List<DBNote> getNotes() {
        String selectStatement = "select * from " + domainName;
        SelectRequest request = new SelectRequest(selectStatement);
        List<DBNote> notes = new ArrayList<>();
        for(Item item : sdbClient.select(request).getItems()) {
            String heading = "";
            String body = "";
            List<Attribute> attributes = item.getAttributes();
            for(Attribute attribute : attributes) {
                switch (attribute.getName()) {
                    case "heading":
                        heading = attribute.getValue();
                        break;
                    case "body":
                        body = attribute.getValue();
                        break;
                    default:
                        logger.info("Unknown attribute: " + attribute.getName());
                }
            }
            DBNote note = new DBNote(item.getName(), heading, body);
            notes.add(note);
        }
        
        return notes;
    }

    @Override
    public void deleteNote(String noteId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNote(DBNote note) {
        ReplaceableItem noteItem = new ReplaceableItem();
        noteItem.setName("note_" + note.getId());
        List<ReplaceableAttribute> attributes = new ArrayList<>();
        attributes.add(new ReplaceableAttribute("heading", note.getHeading(), Boolean.TRUE));
        attributes.add(new ReplaceableAttribute("body", note.getBody(), Boolean.TRUE));
        noteItem.setAttributes(attributes);
        sdbClient.putAttributes(new PutAttributesRequest(domainName, noteItem.getName(), noteItem.getAttributes()));
    }
}
