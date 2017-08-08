package service;

import model.User;

import java.util.List;

public interface UserService {

    User get (int id);
    User getWithContacts(int id);
    User getByLogin(String login);
    List<User> getAll ();

    void delete (int id);

    void update (User user);
    User create(User user);
}
