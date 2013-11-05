package org.silicanote.engine.service;

import java.util.List;
import javax.annotation.Resource;
import org.silicanote.engine.dao.NoteDao;
import org.silicanote.model.Note;
import org.springframework.stereotype.Service;

/**
 *
 * @author Markus Svensson
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteDao dao;
    
    public Note getNote(long noteId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Note> getNotes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteNote(long noteId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addNote(Note note) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDao(NoteDao dao) {
        this.dao = dao;
    }
}
