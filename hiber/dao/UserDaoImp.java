package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {

        sessionFactory.getCurrentSession().save(user);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
// если честно понятия не имею как,но оно все еще работает и я бооюсь это трогать
    @Override
    public User getUserByCar(String carModel, int carSeries) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Car where model = '" + carModel + "' AND  series = " + carSeries);
        return query.getResultList().get(0).getUser();
    }
}