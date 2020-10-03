package tk.exdeath.view.lessons;

import tk.exdeath.controller.counter.LessonsCounter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class LessonsProcessor {

    private final LocalDate NULL_DATE = LocalDate.MIN;

    private final LessonsCounter COUNTER = beforeWhatHolidays();



    public String getLessonInformation(String lessonName, String userLogin) {
        String lessonInformation;

        lessonInformation = "Предмет: " + lessonName + "\nКоличество уроков до " + holidaysName() + " каникул: " + lessonsBeforeHolidays(lessonName, userLogin);

        if (lastLessonIsNotNull()) {
            lessonInformation += "\nДата последнего урока: " + lastLessonDate() + "\nИнформация о нём: " + lastLesson();
        }
        return lessonInformation;
    }



    private boolean lastLessonIsNotNull() {
        return !COUNTER.getLastLessonDate().equals(NULL_DATE);
    }

    private int lessonsBeforeHolidays(String lessonName, String userLogin) {
        return COUNTER.lessonsBeforeHolidays(lessonName, userLogin);
    }

    private String lastLessonDate() {
        DateTimeFormatter dayMonthYear = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return COUNTER.getLastLessonDate().format(dayMonthYear);
    }

    private String lastLesson() {
        return COUNTER.getLastLesson().toRoomAndDayOfWeek();
    }

    private String holidaysName() {
        return COUNTER.getHolidaysName();
    }

    abstract LessonsCounter beforeWhatHolidays();
}
