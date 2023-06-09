package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager em;
   // добавление юзера
   @Override
   public void add(User user) {
      em.persist(user);
   }

   @Override
   public void upd(User user) {
      em.merge(user);
   }

   // список юзеров
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query= (TypedQuery<User>) em.createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserById(long id) {
      return em.find(User.class, id);
   }

   //удаление юзера
   @Override
   public void delete(long id) {
      em.remove(em.find(User.class, id));
   }
}
