package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public User get(int id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void delete(int id){
        userDao.removeById(id);
    }
    @Override
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        userDao.save(user);
    }
    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return userDao.save(user);
    }

    @Override
    public User getWithContacts(int id) {
        return userDao.getWithContact(id);
    }
}
