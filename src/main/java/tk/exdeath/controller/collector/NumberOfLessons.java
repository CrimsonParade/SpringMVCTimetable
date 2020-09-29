package tk.exdeath.controller.collector;

import tk.exdeath.controller.counter.LessonsCounter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class NumberOfLessons {

    private final LessonsCounter COUNTER = beforeWhatHolidays();

    public String getNumberOfLessons(String lessonName) {
        String numberOfLessons;
        numberOfLessons = "Предмет: " + lessonName + "\nКоличество уроков до " + holidaysName() + " каникул: " + lessonsBeforeSummer(lessonName);
        if (isNotNull()) {
            numberOfLessons += "\nДата последнего урока: " + lastLessonDate() + "\nИнформация о нём: " + lastLesson();
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
