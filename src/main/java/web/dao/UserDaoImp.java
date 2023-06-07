package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

   @Autowired
   private EntityManagerFactory emf;
   // добавление юзера
   @Override
   public void add(User user) {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.persist(user);
      em.getTransaction().commit();
   }

   // список юзеров
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query= (TypedQuery<User>) emf.createEntityManager().createQuery("from User");
      return query.getResultList();
   }

   // изменение юзера
   @Override
   public void edit(long id, User user) {
      emf.createEntityManager().persist(user);
   }

   @Override
   public User getUserById(long id) {
      return emf.createEntityManager().find(User.class, id);
   }

   //удаление юзера
   @Override
   public void delete(long id) {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.remove(em.find(User.class, id));
      em.getTransaction().commit();
   }
}
