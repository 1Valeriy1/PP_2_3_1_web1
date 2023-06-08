package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.controller.UserController;
import web.dao.UserDao;
import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public void delete(long id) {
      userDao.delete(id);
   }

   @Override
   public User getUserById(long id) {
      return userDao.getUserById(id);
   }

   @Override
   public void edit(long id, User user) {
      userDao.edit(id, user);
   }


}
