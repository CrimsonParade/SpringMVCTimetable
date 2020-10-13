package tk.exdeath.controller.processor.lessons;

import tk.exdeath.controller.counter.LessonCounter;
import tk.exdeath.controller.processor.lessons.holidays.LessonCountingProcessor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LessonProcessorRU implements LessonCountingProcessor {

    private final LocalDate NULL_DATE = LocalDate.MIN;

    private LessonCounter counter;


    @Override
    public String getLessonInformation(String lessonName, String userLogin, LessonCounter counter) {

        this.counter = counter;
        String lessonInformation;

        lessonInformation = "Предмет: " + lessonName + "\nКоличество уроков до " + holidaysName() + " каникул: " + lessonsBeforeHolidays(lessonName, userLogin);

        if (lastLessonIsNotNull()) {
            lessonInformation += "\nДата последнего урока: " + lastLessonDate() + "\nИнформация о нём: " + lastLesson();
        }
        return lessonInformation;
    }


    private boolean lastLessonIsNotNull() {
        return !counter.getLastLessonDate().equals(NULL_DATE);
    }

    private int lessonsBeforeHolidays(String lessonName, String userLogin) {
        return counter.lessonsBeforeHolidays(lessonName, userLogin);
    }

    private String lastLessonDate() {
        DateTimeFormatter dayMonthYear = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return counter.getLastLessonDate().format(dayMonthYear);
    }

    private String lastLesson() {
        return counter.getLastLesson().toRoomAndDayOfWeekRU();
    }

    private String holidaysName() {
        return counter.getHolidaysNameRU();
    }
}
