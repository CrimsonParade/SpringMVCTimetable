package tk.exdeath.controller.view.data.days;

import java.util.List;

public interface TimetableProcessor {
    List<String> getTimetable(String dayOfWeek, String userLogin);

    String getTodayDayOfWeek();

    String getTomorrowDayOfWeek();
}
