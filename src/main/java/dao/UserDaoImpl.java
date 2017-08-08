package dao;

import model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository

@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
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
        return em.createNamedQuery(User.DELETE_USER).setParameter("id", id).executeUpdate()!=0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User save(User user) {
        if(user.isNew())em.persist(user); else
        {return em.merge(user);}
        return user;
    }

    @Override
    public User getWithContact(int id) {
        return em.createNamedQuery(User.GET_WITH_CONTACTS,User.class).setParameter("id",id).getSingleResult();
    }
}
