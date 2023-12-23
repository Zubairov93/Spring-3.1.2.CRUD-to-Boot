package Spring31.Crud_to_Boot.Spring312.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import Spring31.Crud_to_Boot.Spring312.models.User;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));;
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }


    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void cleanUsersTable() {

    }
}
