package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.controller.UserController;
import web.dao.UserDao;
import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public void upd(User user) {
      userDao.upd(user);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public void delete(long id) {
      userDao.delete(id);
   }

   @Override
   public User getUserById(long id) {
      return userDao.getUserById(id);
   }

}
