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

   @Override
   public void add(User user) {
      emf.createEntityManager().persist(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query= (TypedQuery<User>) emf.createEntityManager().createQuery("from User");
      return query.getResultList();
   }

}
