package org.silicanote.engine.dao;

import java.util.List;
import javax.annotation.Resource;
import org.silicanote.model.db.DBNote;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author Markus Svensson
 */
public class NoteDaoMongoImpl implements NoteDao {

    @Resource
    MongoTemplate mongoTemplate;
    
    public DBNote getNote(long noteId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DBNote> getNotes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteNote(long noteId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addNote(DBNote note) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
