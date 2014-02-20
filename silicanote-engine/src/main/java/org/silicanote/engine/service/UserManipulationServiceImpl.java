package org.silicanote.engine.service;

import javax.annotation.Resource;
import org.silicanote.engine.dao.UserDao;
import org.springframework.stereotype.Service;

/**
 *
 * @author markus
 */
@Service
public class UserManipulationServiceImpl implements UserManipulationService{

    @Resource
    private UserDao dao;
    
    @Override
    public void addUser(String userName, String password) {
        dao.addUser(userName, password);
    }
}
