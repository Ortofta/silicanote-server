package org.silicanote.engine.dao;

import com.amazonaws.services.simpledb.AmazonSimpleDB;
import javax.annotation.Resource;
import org.silicanote.model.db.DBUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author markus
 */
public class UserDaoAwsSImpleDbImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(NoteDaoAwsSimpleDbImpl.class);

    @Resource
    private AmazonSimpleDB sdbClient;

    @Resource
    private String userDomainName;
    
    @Override
    public DBUser getUser(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
