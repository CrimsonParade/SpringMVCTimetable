package tk.exdeath.controller.counter;

public class BeforeNearestHolidays extends LessonsCounter {

    @Override
    long daysBeforeHolidays() {
        return ConstantPull.DAYS_BEFORE_NEAREST_HOLIDAYS;
    }

    @Override
    public String getHolidaysName() {
        return "ближайших";
    }
}
