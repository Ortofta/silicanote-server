package org.silicanote.engine.service;

import java.util.List;
import org.silicanote.model.db.DBNote;

/**
 *
 * @author Markus Svensson
 */
public interface NoteService {
    public DBNote getNote(Long noteId);
    public List<DBNote> getNotes();
    public void deleteNote(Long noteId);
    public void addNote(DBNote note);
}
