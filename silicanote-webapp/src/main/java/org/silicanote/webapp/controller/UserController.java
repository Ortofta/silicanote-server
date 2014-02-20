package org.silicanote.webapp.controller;

import javax.annotation.Resource;
import org.silicanote.engine.service.UserManipulationService;
import org.silicanote.model.web.WebUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author markus
 */
@Controller
@RequestMapping("/services/users")
public class UserController {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Resource
    private UserManipulationService userService;
    
    @RequestMapping(value="/adduser", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createUser(@RequestBody WebUser user){
        userService.addUser(user.getUsername(), user.getPassword());
    }
    @RequestMapping(value="/deleteuser/{userName}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deleteUser(@PathVariable("userName") String userName) {
        userService.deleteUser(userName);
    }
    
    @ExceptionHandler(value=IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public void handleIllegalStateException(Exception e) {
        LOGGER.error("IllegalStateException: " + e.getMessage(), e);
    }
    
    @ExceptionHandler(value=IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public void handleIllegalArgumentException(Exception e) {
        LOGGER.error("IllegalArgumentException: " + e.getMessage(), e);
    }
}
