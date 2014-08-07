package org.silicanote.model.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jongo.marshall.jackson.oid.Id;

/**
 *
 * @author Markus Svensson
 */
public class DBNote {
    @Id
    private String _id;
    
    @JsonProperty("nid")
    private String noteId;
    
    @JsonProperty("h")
    private String heading;
    
    @JsonProperty("b")
    private String body;

    public DBNote() {
        
    }
    
    public DBNote(String id, String heading, String body) {
        this.noteId = id;
        this.heading = heading;
        this.body = body;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getNoteId() {
        return noteId;
    }
    
    public String getId() {
        return noteId;
    }

    public String getHeading() {
        return heading;
    }

    public String getBody() {
        return body;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this._id);
        hash = 59 * hash + Objects.hashCode(this.noteId);
        hash = 59 * hash + Objects.hashCode(this.heading);
        hash = 59 * hash + Objects.hashCode(this.body);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DBNote other = (DBNote) obj;
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        if (!Objects.equals(this.noteId, other.noteId)) {
            return false;
        }
        if (!Objects.equals(this.heading, other.heading)) {
            return false;
        }
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBNote{" + "_id=" + _id + ", noteId=" + noteId + ", heading=" + heading + ", body=" + body + '}';
    }
}
