package org.silicanote.engine.dao;

import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.model.Attribute;
import com.amazonaws.services.simpledb.model.DeleteAttributesRequest;
import com.amazonaws.services.simpledb.model.Item;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.ReplaceableItem;
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
        String selectStatement = "select password from " + userDomainName + " where itemName() = '" + userName + "'";
        SelectRequest request = new SelectRequest(selectStatement);
        List<DBUser> users = new ArrayList<>();

        for (Item item : sdbClient.select(request).getItems()) {
            String password = "";
            List<Attribute> attributes = item.getAttributes();
            for (Attribute attribute : attributes) {
                switch (attribute.getName()) {
                    case "password":
                        password = attribute.getValue();
                        break;
                    default:
                        logger.info("Unknown attribute: " + attribute.getName());
                }
            }
            DBUser note = new DBUser(userName, password);
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

    @Override
    public void addUser(String userName, String password) {
        if(userExists(userName)) {
            throw new IllegalArgumentException("The user " + userName + " already exists!");
        }
        
        ReplaceableItem userItem = new ReplaceableItem();
        userItem.setName(userName);
        List<ReplaceableAttribute> attributes = new ArrayList<>();
        attributes.add(new ReplaceableAttribute("password", password, Boolean.TRUE));
        userItem.setAttributes(attributes);

        sdbClient.putAttributes(new PutAttributesRequest(userDomainName, userItem.getName(), userItem.getAttributes()));
    }

    private boolean userExists(String userName) {
        String selectStatement = "select count(*) from " + userDomainName + " where itemName() = '" + userName + "'";
        SelectRequest request = new SelectRequest(selectStatement);
        List<Item> count = sdbClient.select(request).getItems();
        Item domain = count.get(0);
        for(Attribute attr : domain.getAttributes()) {
            if(attr.getName().equals("Count")){
                int result = Integer.parseInt(attr.getValue());
                return result != 0;
            }
        }
        throw new IllegalStateException("No count attribute was found - can't verify if the user exists or not");
    }

    @Override
    public void deleteUser(String userName) {
        sdbClient.deleteAttributes(new DeleteAttributesRequest(userDomainName, userName));
    }
}
