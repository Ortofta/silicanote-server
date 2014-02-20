package org.silicanote.engine.service;

/**
 *
 * @author markus
 */
public interface UserManipulationService {
    public void addUser(String userName, String password);
    public void deleteUser(String userName);
}
