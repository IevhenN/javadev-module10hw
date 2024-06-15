package home.hw.tool;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public final class Time {
    private Time() {

    }

    public static String getCurrentTime(String timeZoneStr) {
        ZoneId zoneId = ZoneId.of(timeZoneStr.replace("UTC", "GMT"));
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'UTC'");
        String formattedDateTime = now.format(formatter);

        String offset = timeZoneStr.replace("UTC", "");
        return formattedDateTime.replace("UTC", "UTC" + offset);
    }

    public static String convertTimeZone(String timeZoneStr) {
        return timeZoneStr.replace(" ", "+");
    }
}
