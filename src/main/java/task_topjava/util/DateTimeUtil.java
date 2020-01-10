package task_topjava.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    private DateTimeUtil() {}

    public static String toString(LocalDateTime ldt) { return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER); }

    public static boolean isTheSameDay(LocalDateTime ldt) {
        LocalDate now = LocalDate.now();
        return now.isEqual(ldt.toLocalDate());
    }

    public static boolean isAfterElevenHours(LocalDateTime ldt) {
        LocalTime now = LocalTime.now();
        return ldt.toLocalTime().isAfter(now);
    }
}
