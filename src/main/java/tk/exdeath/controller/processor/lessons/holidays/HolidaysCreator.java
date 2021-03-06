package tk.exdeath.controller.processor.lessons.holidays;

import tk.exdeath.controller.processor.lessons.LessonProcessorCreator;

public abstract class HolidaysCreator {

    public static Holidays getInstance(String holidaysName, String language) {

        if (holidaysName.equals("summer")) {
            return new SummerHolidays(LessonProcessorCreator.getInstance(language));
        }
        return new NearestHolidays(LessonProcessorCreator.getInstance(language));
    }
}
