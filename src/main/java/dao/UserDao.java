package dao;

import model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User getById(int id);
    User getWithContact(int id);
    User getByLogin(String login);
    boolean removeById(int id);
    User save(User user);
}
