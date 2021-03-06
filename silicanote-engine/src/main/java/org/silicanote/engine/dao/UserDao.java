package org.silicanote.engine.dao;

import org.silicanote.model.db.DBUser;

/**
 *
 * @author markus
 */
public interface UserDao {
    public DBUser getUser(String userName);
    public void addUser(String userName, String password);
    public void deleteUser(String userName);
}
