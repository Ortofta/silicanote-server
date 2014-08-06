package org.silicanote.engine.service;

import javax.annotation.Resource;
import org.silicanote.engine.dao.UserDao;
import org.silicanote.model.db.DBUser;
import org.silicanote.model.web.WebUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author markus
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource(name = "simpleDbUserDao")
    private UserDao dao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        DBUser user = dao.getUser(userName);
        
        if (user == null) {
            throw new UsernameNotFoundException("User name " + userName + " does not exist");
        }

        return new WebUser(user.getUserName(), user.getPassword());
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}
