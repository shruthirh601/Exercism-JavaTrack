class Leap {

    boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true; // Divisible by 400 (e.g., 2000, 2400)
        } else if (year % 100 == 0) {
            return false; // Divisible by 100 but not by 400 (e.g., 1900, 2100)
        } else if (year % 4 == 0) {
            return true; // Divisible by 4 but not by 100 (e.g., 2024, 2028)
        } else {
            return false; // Not divisible by 4 (e.g., 2023, 2025)
        }
    }

}
