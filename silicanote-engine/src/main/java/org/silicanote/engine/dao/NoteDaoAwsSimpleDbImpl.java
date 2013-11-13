package org.silicanote.engine.dao;

import java.util.List;
import org.silicanote.model.db.DBNote;

/**
 *
 * @author Markus Svensson
 */
public class NoteDaoAwsSimpleDbImpl implements NoteDao{

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
