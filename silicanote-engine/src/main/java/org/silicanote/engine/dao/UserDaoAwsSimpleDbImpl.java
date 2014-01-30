package org.silicanote.engine.dao;

import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.model.Attribute;
import com.amazonaws.services.simpledb.model.Item;
import com.amazonaws.services.simpledb.model.SelectRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.silicanote.model.db.DBUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author markus
 */
public class UserDaoAwsSimpleDbImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(NoteDaoAwsSimpleDbImpl.class);

    @Resource
    private AmazonSimpleDB sdbClient;

    @Resource
    private String userDomainName;
    
    @Override
    public DBUser getUser(String userName) {
        String selectStatement = "select password from " + userDomainName + " where username = '" + userName + "'";
        SelectRequest request = new SelectRequest(selectStatement);
        List<DBUser> users = new ArrayList<>();
                
        for (Item item : sdbClient.select(request).getItems()) {
            String password = "";
            List<Attribute> attributes = item.getAttributes();
            for (Attribute attribute : attributes) {
                switch (attribute.getName()) {
                    case "username":
                        userName = attribute.getValue();
                        break;
                    case "password":
                        password = attribute.getValue();
                        break;
                    default:
                        logger.info("Unknown attribute: " + attribute.getName());
                }
            }
            DBUser note = new DBUser(item.getName(), userName, password);
            users.add(note);
        }

        if (users.size() > 1) {
            throw new IllegalArgumentException("More than one user with user name " + userName + " was found.");
        }

        if (users.isEmpty()) {
            throw new IllegalArgumentException("No user with user name " + userName + " was found.");
        } else {
            return users.get(0);
        }
    }
    
}
