package org.silicanote.engine.service;

import java.util.List;
import org.silicanote.model.db.DBNote;

/**
 *
 * @author Markus Svensson
 */
public interface NoteService {
    public DBNote getNote(String noteId, String userName);
    public List<DBNote> getNotes(String userName);
    public void deleteNote(String noteId, String userName);
    public void addNote(DBNote note, String userName);
}
