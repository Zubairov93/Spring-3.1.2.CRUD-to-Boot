package Spring31.Crud_to_Boot.Spring312.dao;


import Spring31.Crud_to_Boot.Spring312.models.User;

import java.util.List;

public interface UserDao {
     void saveUser(User user);
     List<User> listUsers();

     User getById(int id);

     void update(User user);

     void delete(int id);



}
