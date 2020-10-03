package tk.exdeath.model.hibernate;

import org.hibernate.Session;
import tk.exdeath.model.Lesson;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class LessonDAO extends DAO {

    public List<Lesson> readByDayOfWeek(String dayOfWeek){
        Criteria criteria = new Criteria();
        return criteria.byDayOfWeek(dayOfWeek);
    }


    public List<Lesson> readAllLessons() {
        Criteria criteria = new Criteria();
        return criteria.allLessons();
    }

    private class Criteria {

        Session session = HibernateFactory.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Lesson> criteria = builder.createQuery(Lesson.class);
        Root<Lesson> root = criteria.from(Lesson.class);


        List<Lesson> byDayOfWeek(String dayOfWeek) {
            criteria.select(root).where(builder.like(root.get("dayOfWeek"), dayOfWeek));
            criteria.orderBy(builder.asc(root.get("lessonNumber")));

            List<Lesson> lessons = session.createQuery(criteria).getResultList();
            session.close();

            return lessons;
        }

        List<Lesson> allLessons(){
            criteria.select(root);

            List<Lesson> lessons = session.createQuery(criteria).getResultList();
            session.close();

            return lessons;
        }

    }
}
