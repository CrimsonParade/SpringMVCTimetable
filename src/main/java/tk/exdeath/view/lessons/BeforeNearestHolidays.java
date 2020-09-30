package tk.exdeath.view.lessons;


import tk.exdeath.controller.counter.NearestHolidays;
import tk.exdeath.controller.counter.LessonsCounter;

public class BeforeNearestHolidays extends NumberOfLessonsProcessor {

    @Override
    LessonsCounter beforeWhatHolidays() {
        return new NearestHolidays();
    }
}