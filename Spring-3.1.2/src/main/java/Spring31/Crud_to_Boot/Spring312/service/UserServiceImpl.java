package Spring31.Crud_to_Boot.Spring312.service;


import Spring31.Crud_to_Boot.Spring312.dao.UserDao;
import Spring31.Crud_to_Boot.Spring312.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements  UserService{
    private final UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) throws SQLException {
        userDao.saveUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}