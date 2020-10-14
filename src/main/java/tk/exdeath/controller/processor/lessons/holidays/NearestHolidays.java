package tk.exdeath.controller.processor.lessons.holidays;

import tk.exdeath.controller.counter.BeforeNearestHolidays;
import tk.exdeath.controller.processor.lessons.LessonProcessor;

public class NearestHolidays implements Holidays {

    private final LessonProcessor processor;

    public NearestHolidays(LessonProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String getLessonInformation(String lessonName, String userLogin) {
        return processor.getLessonInformation(lessonName, userLogin, new BeforeNearestHolidays());
    }
}