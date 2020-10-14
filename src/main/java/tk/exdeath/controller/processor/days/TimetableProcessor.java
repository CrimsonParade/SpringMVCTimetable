package tk.exdeath.controller.processor.days;

import java.util.List;

public interface TimetableProcessor {
    List<String> getTimetable(String dayOfWeek, String userLogin);

    String getTodayDayOfWeek();

    String getTomorrowDayOfWeek();
}
