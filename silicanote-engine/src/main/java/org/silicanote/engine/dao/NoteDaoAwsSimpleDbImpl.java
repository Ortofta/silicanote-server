package org.silicanote.engine.dao;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.ReplaceableItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.silicanote.model.db.DBNote;

/**
 *
 * @author Markus Svensson
 */
public class NoteDaoAwsSimpleDbImpl implements NoteDao {

    private static final String DOMAIN_NAME = "SilicaNoteDataStore";
    
    @Resource
    private AmazonSimpleDB sdb;
    

    public void createDomain(String domainName) {
        sdb.setRegion(Region.getRegion(Regions.US_EAST_1));
        sdb.createDomain(new CreateDomainRequest(DOMAIN_NAME));
    }

    @Override
    public DBNote getNote(Long noteId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DBNote> getNotes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteNote(Long noteId) {
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
        sdb.putAttributes(new PutAttributesRequest(DOMAIN_NAME, noteItem.getName(), noteItem.getAttributes()));
    }
}
