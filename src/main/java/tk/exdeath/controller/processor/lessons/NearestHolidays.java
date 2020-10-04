package tk.exdeath.controller.processor.lessons;


import tk.exdeath.controller.counter.BeforeNearestHolidays;
import tk.exdeath.controller.counter.LessonsCounter;

public class NearestHolidays extends LessonsCountProcessor {

    @Override
    LessonsCounter beforeWhatHolidays() {
        return new BeforeNearestHolidays();
    }
}