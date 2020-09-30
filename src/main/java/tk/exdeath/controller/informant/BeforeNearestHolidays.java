package tk.exdeath.controller.informant;


import tk.exdeath.controller.counter.NearestHolidays;
import tk.exdeath.controller.counter.LessonsCounter;

public class BeforeNearestHolidays extends NumberOfLessons {

    @Override
    LessonsCounter beforeWhatHolidays() {
        return new NearestHolidays();
    }
}