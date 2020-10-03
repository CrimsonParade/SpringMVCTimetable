package tk.exdeath.model.hibernate;

import org.hibernate.Session;
import tk.exdeath.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDAO extends DAO {

    public List<User> readAllUsers() {
        Criteria criteria = new Criteria();
        return criteria.allUsers();
    }

    public User readByLogin(String login) {
        Criteria criteria = new Criteria();
        return criteria.byLogin(login);
    }

    private class Criteria {
        Session session = HibernateFactory.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        User byLogin(String login) {
            User user = session.createQuery(criteria.select(root).where(builder.like(root.get("login"), login))).uniqueResult();

            session.close();
            return user;
        }

        List<User> allUsers() {
            List<User> users = session.createQuery(criteria.select(root)).getResultList();

            session.close();
            return users;
        }
    }
}
