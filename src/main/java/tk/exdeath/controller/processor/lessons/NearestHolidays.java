package tk.exdeath.controller.processor.lessons;


import tk.exdeath.controller.counter.BeforeNearestHolidays;
import tk.exdeath.controller.counter.LessonCounter;

public class NearestHolidays extends LessonCountingProcessor {

    @Override
    LessonCounter beforeWhatHolidays() {
        return new BeforeNearestHolidays();
    }
}