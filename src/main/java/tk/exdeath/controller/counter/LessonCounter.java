package tk.exdeath.controller.counter;

import tk.exdeath.model.Holiday;
import tk.exdeath.model.Lesson;
import tk.exdeath.model.service.UserService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public abstract class LessonCounter {

    private final LocalDate NULL_DATE = LocalDate.MIN;
    private final UserService userService = new UserService();
    private Lesson lastLesson;
    private LocalDate lastLessonDate = NULL_DATE;
    private List<Holiday> holidays;


    public int lessonsBeforeHolidays(String lessonName, String userLogin) {
        LocalDate lessonDate = dateWithoutHolidays();
        int i = counterWithoutHolidays(lessonDate);
        int daysBeforeHolidays = (int) daysBeforeHolidays(userLogin);
        int numberOfLessons = 0;
        holidays = getSortedHolidays(userLogin);

        while (i <= daysBeforeHolidays) {
            for (Lesson lesson : userService.readLessonsByDayOfWeek(lessonDate.format(DateTimeFormatter.ofPattern("EEEE")), userLogin)) {
                if (lesson.getLessonName().equals(lessonName)) {
                    lastLesson = lesson;
                    lastLessonDate = lessonDate;
                    numberOfLessons++;
                }
            }
            i = addCounterValue(lessonDate, i);
            lessonDate = addDays(lessonDate);
        }

        return numberOfLessons;
    }


    private int addCounterValue(LocalDate lessonDate, int counterValue) {
        for (Holiday holiday : holidays) {
            LocalDate holidayDate = LocalDate.of(holiday.getYear(), holiday.getMonth(), holiday.getDay());

            if (lessonDate.equals(holidayDate)) {
                counterValue += (holiday.getLength() + 1);
                return counterValue;
            }
        }
        counterValue++;
        return counterValue;
    }

    private LocalDate addDays(LocalDate lessonDate) {
        for (Holiday holiday : holidays) {
            LocalDate holidayDate = LocalDate.of(holiday.getYear(), holiday.getMonth(), holiday.getDay());

            if (lessonDate.equals(holidayDate)) {
                lessonDate = lessonDate.plusDays((holiday.getLength() + 1));
                return lessonDate;
            }
        }
        lessonDate = lessonDate.plusDays(1);
        return lessonDate;
    }

    private LocalDate dateWithoutHolidays() {
        return addDays(dateNow().minusDays(1));
    }

    private int counterWithoutHolidays(LocalDate lessonDate) {
        return addCounterValue(lessonDate, -1);
    }


    public List<Holiday> getSortedHolidays(String userLogin) {
        List<Holiday> holidays = userService.readUserByLogin(userLogin).getHolidays();
        holidays.sort(Comparator.comparing(Holiday::hashCode));
        return holidays;
    }

    LocalDate dateNow() {
        if (LocalTime.now().getHour() > 17) {
            return LocalDate.now().plusDays(1);
        }
        return LocalDate.now();
    }


    abstract long daysBeforeHolidays(String userLogin);

    public abstract String getHolidaysNameRU();

    public abstract String getHolidaysNameENG();

    public LocalDate getLastLessonDate() {
        return lastLessonDate;
    }

    public Lesson getLastLesson() {
        return lastLesson;
    }
}
