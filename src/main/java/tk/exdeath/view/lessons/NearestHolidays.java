package tk.exdeath.view.lessons;


import tk.exdeath.controller.counter.BeforeNearestHolidays;
import tk.exdeath.controller.counter.LessonsCounter;

public class NearestHolidays extends LessonsProcessor {

    @Override
    LessonsCounter beforeWhatHolidays() {
        return new BeforeNearestHolidays();
    }
}