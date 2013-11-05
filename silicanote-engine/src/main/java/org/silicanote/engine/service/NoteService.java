package org.silicanote.engine.service;

import java.util.List;
import org.silicanote.model.Note;

/**
 *
 * @author Markus Svensson
 */
public interface NoteService {
    public Note getNote(long noteId);
    public List<Note> getNotes();
    public void deleteNote(long noteId);
    public void addNote(Note note);
}
