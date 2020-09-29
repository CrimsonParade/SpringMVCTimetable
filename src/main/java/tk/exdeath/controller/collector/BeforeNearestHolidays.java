package tk.exdeath.controller.collector;


import tk.exdeath.controller.counter.NearestHolidays;
import tk.exdeath.controller.counter.LessonsCounter;

public class BeforeNearestHolidays extends NumberOfLessons {

    @Override
    LessonsCounter beforeWhatHolidays() {
        return new NearestHolidays();
    }
}