package org.silicanote.model.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jongo.marshall.jackson.oid.Id;

/**
 *
 * @author Markus Svensson
 */
public class DBUser {
    @Id
    private String _id;
    
    @JsonProperty("un")
    private String userName;
    
    @JsonProperty("pw")
    private String password;

    public DBUser() {
        
    }
    
    public DBUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public void setUserName(String un) {
        this.userName = un;
    }

    public String getUserName() {
        return userName;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this._id);
        hash = 59 * hash + Objects.hashCode(this.userName);
        hash = 59 * hash + Objects.hashCode(this.password);
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
        final DBUser other = (DBUser) obj;
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBUser{" + "_id=" + _id + ", userName=" + userName + ", password=" + password + '}';
    }
}
