package tk.exdeath.model.hibernate;

import org.hibernate.Session;
import tk.exdeath.model.Lesson;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class LessonDAO extends DAO {

    Session session = HibernateFactory.getSessionFactory().openSession();
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Lesson> criteria = builder.createQuery(Lesson.class);
    Root<Lesson> root = criteria.from(Lesson.class);

    public List<Lesson> readByDayOfWeek(String dayOfWeek){
        criteria.select(root).where(builder.like(root.get("dayOfWeek"), dayOfWeek));
        criteria.orderBy(builder.asc(root.get("lessonNumber")));

        return session.createQuery(criteria).getResultList();
    }


    public List<Lesson> readAllLessons() {
        criteria.select(root);

        return session.createQuery(criteria).getResultList();
    }

    protected void finalize()
    {
        try {
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
