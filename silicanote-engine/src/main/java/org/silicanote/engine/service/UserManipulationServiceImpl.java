package org.silicanote.engine.service;

import javax.annotation.Resource;
import org.silicanote.engine.dao.UserDao;
import org.springframework.stereotype.Service;

/**
 *
 * @author Markus Svensson
 */
@Service
public class UserManipulationServiceImpl implements UserManipulationService{

    @Resource(name = "simpleDbUserDao")
    private UserDao dao;
    
    @Override
    public void addUser(String userName, String password) {
        dao.addUser(userName, password);
    }

    @Override
    public void deleteUser(String userName) {
        dao.deleteUser(userName);    
    }
}
