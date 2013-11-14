package org.silicanote.engine.dao;

import java.util.List;
import org.silicanote.model.db.DBNote;

/**
 *
 * @author Markus Svensson
 */
public interface NoteDao {
    public DBNote getNote(String noteId);
    public List<DBNote> getNotes();
    public void deleteNote(String noteId);
    public void addNote(DBNote note);
}
