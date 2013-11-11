package org.silicanote.model.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Markus Svensson
 */
@Document
public class DBNote {
    @Id
    private final Long id;
    
    @Indexed
    private final String heading;
    
    @Indexed
    private final String body;

    public DBNote(Long id, String heading, String body) {
        this.id = id;
        this.heading = heading;
        this.body = body;
    }
    
    public Long getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public String getBody() {
        return body;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 53 * hash + (this.heading != null ? this.heading.hashCode() : 0);
        hash = 53 * hash + (this.body != null ? this.body.hashCode() : 0);
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
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.heading == null) ? (other.heading != null) : !this.heading.equals(other.heading)) {
            return false;
        }
        if ((this.body == null) ? (other.body != null) : !this.body.equals(other.body)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBNote{" + "id=" + id + ", heading=" + heading + ", body=" + body + '}';
    }
}
