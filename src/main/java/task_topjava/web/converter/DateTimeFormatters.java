package task_topjava.web.converter;

import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatters {
    public static class LocalDateFormatter implements Formatter<LocalDate> {

        @Override
        public LocalDate parse(String s, Locale locale) throws ParseException {
            return StringUtils.isEmpty(s) ? null : LocalDate.parse(s);
        }

        @Override
        public String print(LocalDate localDate, Locale locale) {
            return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }

    public static class LocalTimeFormatter implements Formatter<LocalTime> {

        @Override
        public LocalTime parse(String s, Locale locale) throws ParseException {
            return StringUtils.isEmpty(s) ? null : LocalTime.parse(s);
        }

        @Override
        public String print(LocalTime localTime, Locale locale) {
            return localTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        }
    }
}
