package org.silicanote.engine.service;

import java.util.List;
import javax.annotation.Resource;
import org.silicanote.engine.dao.NoteDao;
import org.silicanote.model.db.DBNote;
import org.silicanote.model.web.WebNote;
import org.springframework.stereotype.Service;

/**
 *
 * @author Markus Svensson
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteDao dao;
    
    public DBNote getNote(Long noteId) {
        return dao.getNote(noteId);
    }

    public List<DBNote> getNotes() {
        return dao.getNotes();
    }

    public void deleteNote(Long noteId) {
        dao.deleteNote(noteId);
    }

    public void addNote(DBNote note) {
        dao.addNote(note);
    }

    public void setDao(NoteDao dao) {
        this.dao = dao;
    }
}
