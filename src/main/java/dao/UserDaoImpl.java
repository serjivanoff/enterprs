package dao;

import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.ALL_USERS,User.class).getResultList();
    }

    @Override
    public User getById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public boolean removeById(int id) {
        return em.createNamedQuery(User.DELETE_USER,User.class).setParameter("id", id).executeUpdate()!=0;
    }

    @Override
    public User save(User user) {
        if(user.isNew())em.persist(user); else
        {return em.merge(user);}
        return user;
    }
}
