package org.silicanote.engine.service;

import java.util.List;
import javax.annotation.Resource;
import org.silicanote.engine.dao.NoteDao;
import org.silicanote.model.db.DBNote;
import org.springframework.stereotype.Service;

/**
 *
 * @author Markus Svensson
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteDao dao;
    
    @Override
    public DBNote getNote(String noteId) {
        return dao.getNote(noteId);
    }

    @Override
    public List<DBNote> getNotes() {
        return dao.getNotes();
    }

    @Override
    public void deleteNote(String noteId) {
        dao.deleteNote(noteId);
    }

    @Override
    public void addNote(DBNote note) {
        dao.addNote(note);
    }

    public void setDao(NoteDao dao) {
        this.dao = dao;
    }
}
