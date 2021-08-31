package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {

        sessionFactory.openSession().save(user);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.openSession().createQuery("from User");
        return query.getResultList();
    }

    // если честно понятия не имею как,но оно все еще работает и я бооюсь это трогать
    @Override
    public User getUserByCar(String model, int series) {
        String hql = "FROM User u LEFT JOIN FETCH u.car WHERE u.car.model = :model AND u.car.series = :series";

        TypedQuery<User> query = sessionFactory.openSession().createQuery(hql);
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getSingleResult();


    }
}