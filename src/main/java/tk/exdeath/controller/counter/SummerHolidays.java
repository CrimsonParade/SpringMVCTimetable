package tk.exdeath.controller.counter;

public class SummerHolidays extends LessonsCounter {

    @Override
    long daysBeforeHolidays() {
        return ConstantPull.DAYS_BEFORE_SUMMER;
    }

    @Override
    public String getHolidaysName() {
        return "летних";
    }
}