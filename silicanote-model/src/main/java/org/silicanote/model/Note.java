package org.silicanote.model;

/**
 *
 * @author Markus Svensson
 */
public class Note {
    private final String heading;
    private final String body;

    public Note(String heading, String body) {
        this.heading = heading;
        this.body = body;
    }

    public String getHeading() {
        return heading;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Note{" + "heading=" + heading + ", body=" + body + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.heading != null ? this.heading.hashCode() : 0);
        hash = 67 * hash + (this.body != null ? this.body.hashCode() : 0);
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
        final Note other = (Note) obj;
        if ((this.heading == null) ? (other.heading != null) : !this.heading.equals(other.heading)) {
            return false;
        }
        return !((this.body == null) ? (other.body != null) : !this.body.equals(other.body));
    }
}
