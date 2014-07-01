package org.silicanote.engine.dao;

import java.util.List;
import javax.annotation.Resource;
import org.jongo.MongoCollection;
import org.silicanote.model.db.DBNote;

/**
 *
 * @author Markus Svensson
 */
public class NoteDaoMongoImpl implements NoteDao {

    @Resource(name = "noteCollection")
    MongoCollection noteCollection;
    
    @Override
    public DBNote getNote(String noteId, String userName) {
        DBNote note = noteCollection.findOne("{nid: #, uid: #}", noteId, userName).as(DBNote.class);
        return note;
    }

    @Override
    public List<DBNote> getNotes(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteNote(String noteId, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNote(DBNote note, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Resource
//    MongoTemplate mongoTemplate;
    
    
    
}
