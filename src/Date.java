abstract class Date {
    protected int currentYear;
    protected int currentMonth;
    protected int currentDay;
    public void addDays(int days) {
        for (int i = 0; i < days; i++) {
            currentDay += 1;
            if (currentDay > getNumberOfDaysInMonth(currentYear, currentMonth)) {
                currentDay = 1;
                currentMonth += 1;
                if (currentMonth > 12) {
                    currentMonth = 1;
                    currentYear += 1;
                }
            }
        }
    }
    public void subtractDays(int days) {
        for (int i = 0; i < days; i++) {
            currentDay -= 1;
            if (currentDay < 1) {
                currentMonth -= 1;
                if (currentMonth < 1) {
                    currentMonth = 12;
                    currentYear -= 1;
                }
                currentDay = getNumberOfDaysInMonth(currentYear, currentMonth);
            }
        }
    }
    public void printShortDate() {
        System.out.print(getMonth() + "/");
        System.out.print(getDayOfMonth() + "/");
        System.out.print(getYear());
    }
    public void printLongDate() {
        System.out.print(getMonthName() + " ");
        System.out.print(getDayOfMonth() + ", ");
        System.out.print(getYear());
    }
    public String getMonthName() {
        return getMonthName(currentMonth);
    }
    public int getMonth() {
        return currentMonth;
    }
    public int getYear() {
        return currentYear;
    }
    public int getDayOfMonth() {
        return currentDay;
    }
    public int[] MONTH_LENGTHS = new int[]{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    protected int getNumberOfDaysInMonth(int year, int month) {
        if (isLeapYear(year)) {
            if (month == 2) {
                return MONTH_LENGTHS[month - 1] + 1;
            }
        }
        return MONTH_LENGTHS[month - 1];
    }
    public boolean isLeapYear() {
        return isLeapYear( currentYear);
    }
    public abstract boolean isLeapYear(int year);
    private int getNumberOfDaysInYear(int year) {
        int yearDays = 0;
        for (int i = 0; i < 12; i++) {
            yearDays += getNumberOfDaysInMonth(year, i);
        }
        return yearDays;
    }
    private final String[] MONTH_NAMES = new String[] {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };
    private String getMonthName(int month) {
        return MONTH_NAMES[month - 1];
    }
}