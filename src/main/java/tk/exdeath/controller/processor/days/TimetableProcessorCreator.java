package tk.exdeath.controller.processor.days;

public abstract class TimetableProcessorCreator {

    public static TimetableProcessor getInstance(String language) {

        if (language.equals("ENG")) {
            return new TimetableProcessorENG();
        }
        return new TimetableProcessorRU();
    }
}
