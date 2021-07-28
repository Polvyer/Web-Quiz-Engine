package engine.api.service;

import engine.api.entity.User;

public interface UserService {

    User getUserFromPrincipal();

    String getEmailFromPrincipal();

    void addUser(User user);
}
