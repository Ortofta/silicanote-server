package org.silicanote.engine.service;

import org.silicanote.model.db.DBUser;

/**
 *
 * @author markus
 */
public interface UserService {
    public DBUser getUser(String userName);
    
}
