package tk.exdeath.model.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "exdeath.timetable")
public class Timetable implements Serializable {


    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "lessonnumber")
    private int lessonNumber;
    @Column(name = "dayofweek")
    private String dayOfWeek;
    @Column(name = "lessonname")
    private String lessonName;
    @Column(name = "roomnumber")
    private String roomNumber;
    @Column(name = "teachername")
    private String teacherName;

    public Timetable() {
    }

    @Override
    public String toString() {
        return "\nДень недели: " + dayOfWeek +
                " | Урок номер: " + lessonNumber +
                " | Кабинет: " + roomNumber +
                " | Урок: " + lessonName +
                " | Учитель: " + teacherName;
    }

    public String toHTML() {
        return "<pre>День недели: " + dayOfWeek +
                " | Урок номер: " + lessonNumber +
                " | Кабинет: " + roomNumber +
                " | Урок: " + lessonName +
                " | Учитель: " + teacherName + "<br></pre>";
    }

    public String getLessonName() {
        return lessonName;
    }

}
