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

    @Resource(name = "mongoDao")
    private NoteDao dao;
    
    @Override
    public DBNote getNote(String noteId, String userName) {
        return dao.getNote(noteId, userName);
    }

    @Override
    public List<DBNote> getNotes(String userName) {
        return dao.getNotes(userName);
    }

    @Override
    public void deleteNote(String noteId, String userName) {
        dao.deleteNote(noteId, userName);
    }

    @Override
    public void addNote(DBNote note, String userName) {
        dao.addNote(note, userName);
    }

    public void setDao(NoteDao dao) {
        this.dao = dao;
    }
}
