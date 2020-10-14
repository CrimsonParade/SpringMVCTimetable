package tk.exdeath.controller.processor.lessons;

public abstract class LessonProcessorCreator {

    public static LessonProcessor getInstance(String language) {

        if (language.equals("ENG")) {
            return new LessonProcessorENG();
        }
        return new LessonProcessorRU();
    }
}
