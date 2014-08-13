package org.silicanote.engine.dao;

import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Resource;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import org.silicanote.model.db.DBNote;
import org.springframework.util.StringUtils;

/**
 *
 * @author Markus Svensson
 */
public class NoteDaoMongoImpl implements NoteDao {

    @Resource(name = "noteCollection")
    MongoCollection noteCollection;

    @Override
    public DBNote getNote(String noteId, String userName) {
        DBNote note = noteCollection.findOne("{nid: #, uid: #}", noteId, userName).as(DBNote.class);
        return note;
    }

    @Override
    public List<DBNote> getNotes(String userName) {
        Iterable<DBNote> notes = noteCollection.find("{uid: #}", userName).as(DBNote.class);
        return Lists.newArrayList(notes);
    }

    @Override
    public void deleteNote(String noteId, String userName) {
        noteCollection.remove("{nid: #, uid: #}", noteId, userName);
    }

    @Override
    public void addNote(DBNote note, String userName) {
        if (StringUtils.hasLength(note.getId()) && getNote(note.getId(), userName) != null) {
            noteCollection.update("{nid: #, uid: #}", note.getId(), userName).upsert().with("{h: #, b: #}", note.getHeading(), note.getBody());
        } else {
            noteCollection.insert("{nid: #, uid: #, h: #, b: #}", note.getId(), userName, note.getHeading(), note.getBody());
        }
    }
}
