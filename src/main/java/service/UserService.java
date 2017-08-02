package service;

import model.User;

import java.util.List;

public interface UserService {

    User get (int id);

    List<User> getAll ();

    void delete (int id);

    void update (User user);

    User create(User user);
}
