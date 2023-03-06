package payment.utils

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

// Parses a time sting in format 2011-12-03T10:15:30Z
fun stringToLocalDateTime(datetimeString: String): LocalDateTime {
    return LocalDateTime.parse(datetimeString, DateTimeFormatter.ISO_DATE_TIME)
}

// Parses a LocalDateTIme as a string with format 2011-12-03T10:15:30Z
fun localDateTimeToString(datetime: LocalDateTime): String {
    return datetime.atOffset(ZoneOffset.UTC).toString()
}