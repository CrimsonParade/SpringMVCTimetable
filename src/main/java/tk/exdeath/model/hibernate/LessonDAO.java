package tk.exdeath.model.hibernate;

import org.hibernate.Session;
import tk.exdeath.model.Lesson;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class LessonDAO extends DAO {

    public List<Lesson> readByDayOfWeek(String dayOfWeek){
        Criteria criteria = new Criteria();
        return criteria.byDayOfWeek(dayOfWeek);
    }


    public Set<String> readAllLessons() {
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
            return session.createQuery(criteria).getResultList();
        }

        Set<String> allLessons(){
            Set<String> lessons = new HashSet<>();
            criteria.select(root);

            for (Lesson lesson : session.createQuery(criteria).getResultList()) {
                lessons.add(lesson.getLessonName());
            }
            return lessons;
        }

    }
}
