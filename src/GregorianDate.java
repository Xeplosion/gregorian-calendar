public class GregorianDate extends Date {
    public GregorianDate() {
        // Get the current date
        long currentMill = System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset();
        currentYear = 1970;
        currentMonth = 1;
        currentDay = 1;
        addDays((int)(currentMill / 86_400_000));
    }
    public GregorianDate(int year, int month, int day) {
        currentYear = year;
        currentMonth = month;
        currentDay = day;
    }
    @Override
    public boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        }
        return year % 4 == 0;
    }
}