package tk.exdeath.model.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tk.exdeath.model.User;
import tk.exdeath.model.hibernate.HibernateFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDAO {

    private final Session session = HibernateFactory.getSessionFactory().openSession();
    private final CriteriaBuilder builder = session.getCriteriaBuilder();
    private final CriteriaQuery<User> criteria = builder.createQuery(User.class);
    private final Root<User> root = criteria.from(User.class);

    public void create(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

    public void update(User user) {
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }

    public User readByLogin(String login) {
        return session.createQuery(criteria.select(root).where(builder.like(root.get("login"), login))).uniqueResult();

    }

    protected void finalize() {
        try {
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
