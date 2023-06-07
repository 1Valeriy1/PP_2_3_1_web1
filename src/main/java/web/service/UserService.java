package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    void delete(long id);

    void edit(long id, User user);

    User getUserById(long id);

}
