package tk.exdeath.controller.processor.days;

import tk.exdeath.model.Lesson;
import tk.exdeath.model.service.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class TimetableProcessorENG implements TimetableProcessor {

    private final UserService READER = new UserService();

    @Override
    public String getTodayDayOfWeek() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH));
    }

    @Override
    public String getTomorrowDayOfWeek() {
        return LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH));
    }


    @Override
    public List<String> getTimetable(String dayOfWeek, String userLogin) {

        List<String> timetable = new ArrayList<>();

        if (isHoliday(dayOfWeek, userLogin)) {
            timetable.add("Day off!");
        } else {
            for (Lesson lesson : READER.readLessonsByDayOfWeek(dayOfWeek, userLogin)) {
                timetable.add(lesson.toRoomAndLessonENG());
            }
        }
        return timetable;
    }


    private boolean isHoliday(String dayOfWeek, String userLogin) {
        return READER.readLessonsByDayOfWeek(dayOfWeek, userLogin).isEmpty();
    }
}
