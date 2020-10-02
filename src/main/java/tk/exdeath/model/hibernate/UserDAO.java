package tk.exdeath.model.hibernate;

import org.hibernate.Session;
import tk.exdeath.model.User;

import java.util.List;

public class UserDAO extends DAO {

    private Session getSession() {
        return HibernateFactory.getSessionFactory().openSession();
    }

    public List<User> readAllUsers() {
        return getSession().createQuery("FROM User").list();
    }

    public User readByID(int id) {
        return getSession().get(User.class, id);
    }
}
