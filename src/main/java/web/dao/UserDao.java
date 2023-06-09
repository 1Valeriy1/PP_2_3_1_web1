package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void upd(User user);
   List<User> listUsers();

   void delete(long id);

   User getUserById(long id);


}
