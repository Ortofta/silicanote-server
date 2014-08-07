package org.silicanote.engine.dao;

import javax.annotation.Resource;
import org.jongo.MongoCollection;
import org.silicanote.model.db.DBUser;

/**
 *
 * @author Markus Svensson
 */
public class UserDaoMongoImpl implements UserDao {

    @Resource(name = "userCollection")
    MongoCollection userCollection;

    @Override
    public DBUser getUser(final String userName) {
        return userCollection.findOne("{un: #}", userName).as(DBUser.class);
    }

    @Override
    public void addUser(final String userName, final String password) {
        userCollection.insert("{un: #, pw: #}", userName, password);
    }

    @Override
    public void deleteUser(final String userName) {
        userCollection.remove("{un: #}", userName);
    }

}
