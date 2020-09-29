package tk.exdeath.controller.collector;

import tk.exdeath.controller.counter.LessonsCounter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class NumberOfLessons {

    private final LessonsCounter COUNTER = beforeWhatHolidays();
    public static final String DELIMITER = "-------------------------------------------------------------------------";


    public String getNumberOfLessons(String lessonName) {
        String numberOfLessons;
        numberOfLessons = "<pre>Предмет: " + lessonName + "<br>Количество уроков до " + holidaysName() + " каникул: " + lessonsBeforeSummer(lessonName) + "</pre>";
        if (isNotNull()) {
            numberOfLessons += "<pre>Дата последнего урока: " + lastLessonDate() + "<br>Информация о нём: " + lastLesson() + "</pre>";
        }
        return numberOfLessons;
    }

    private boolean isNotNull() {
        return !COUNTER.getLastLessonDate().equals(LocalDate.MIN);
    }

    private int lessonsBeforeSummer(String lessonName) {
        return COUNTER.lessonsBeforeSummer(lessonName);
    }

    private String lastLessonDate() {
        DateTimeFormatter dayMonthYear = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return COUNTER.getLastLessonDate().format(dayMonthYear);
    }

    private String lastLesson() {
        return COUNTER.getLastLesson().toHTML();
    }

    private String holidaysName() {
        return COUNTER.getHolidaysName();
    }

    abstract LessonsCounter beforeWhatHolidays();
}
