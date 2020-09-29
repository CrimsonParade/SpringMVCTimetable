package tk.exdeath.model.database;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TimetableDAO {

    public List<Timetable> readByDayOfWeek(String dayOfWeek){
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
        CriteriaQuery<Timetable> criteria = builder.createQuery(Timetable.class);
        Root<Timetable> root = criteria.from(Timetable.class);


        List<Timetable> byDayOfWeek(String dayOfWeek) {
            criteria.select(root).where(builder.like(root.get("dayOfWeek"), dayOfWeek));
            criteria.orderBy(builder.asc(root.get("lessonNumber")));
            return session.createQuery(criteria).getResultList();
        }

        Set<String> allLessons(){
            Set<String> lessons = new HashSet<>();
            criteria.select(root);
            for (Timetable table : session.createQuery(criteria).getResultList()) {
                lessons.add(table.getLessonName());
            }
            return lessons;
        }

    }
}
