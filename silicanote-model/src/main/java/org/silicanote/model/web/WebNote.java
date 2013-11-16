package org.silicanote.model.web;

/**
 *
 * @author Markus Svensson
 */
public class WebNote {
    private String id;
    private String heading;
    private String body;

    public WebNote() {
        
    }
    
    public WebNote(String id, String heading, String body) {
        this.id = id;
        this.heading = heading;
        this.body = body;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "WebNote{" + "id=" + id + ", heading=" + heading + ", body=" + body + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.heading != null ? this.heading.hashCode() : 0);
        hash = 79 * hash + (this.body != null ? this.body.hashCode() : 0);
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
        final WebNote other = (WebNote) obj;
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

}
