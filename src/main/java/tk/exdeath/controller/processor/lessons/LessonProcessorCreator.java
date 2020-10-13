package tk.exdeath.controller.processor.lessons;

import tk.exdeath.controller.processor.lessons.holidays.LessonCountingProcessor;

public abstract class LessonProcessorCreator {

    public static LessonCountingProcessor getInstance(String language) {
        if (language.equals("ENG")) {
            return new LessonProcessorENG();
        }
        return new LessonProcessorRU();
    }
}
