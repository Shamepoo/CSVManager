import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

public final class DateUtil {
    public static final LocalDate sep1 = LocalDate.of(LocalDate.now().getYear(), 9, 1);
    public static final LocalDate newYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);

    public static final String EMPTY = "";

    public static DateTimeFormatter defalutDateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("d/M/")
            .optionalStart()
            .appendPattern("uuuu")
            .optionalEnd()
            .optionalStart()
            .appendValueReduced(ChronoField.YEAR, 2, 2, 1920)
            .optionalEnd()
            .toFormatter();

    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public static String calculateAgeByDateOfBirth(String dateOfBirth) {
        if (dateOfBirth.equals("")) {
            return EMPTY;
        }
        LocalDate localDate = null;
        try {
            if (!isLegal(dateOfBirth)) {
                localDate = LocalDate.parse(dateOfBirth, defalutDateTimeFormatter);
            } else {
                localDate = LocalDate.parse(dateOfBirth, dateTimeFormatter);
            }
            return Integer.toString(localDate.until(sep1).getYears());
        } catch (DateTimeParseException | StringIndexOutOfBoundsException e) {
            return EMPTY;

        }


    }

    public static String calculateEndDateByStartDate(String dateOfStartingMembership, int MembershipDuration) {
        if (dateOfStartingMembership.equals("") || MembershipDuration == 0) {
            return EMPTY;
        }
        LocalDate startDate = null;
        try {
            startDate = LocalDate.parse(dateOfStartingMembership, dateTimeFormatter);
            startDate = startDate.plusMonths(MembershipDuration);
            String endDate = startDate.format(dateTimeFormatter);
            return endDate;

        } catch (DateTimeParseException | StringIndexOutOfBoundsException e) {
            return EMPTY;
        }
    }

    public static int calculateDurationInCurrentYear(String dateOfStartingMembership, String dateOfEndingMembership) {
        if (dateOfEndingMembership.equals("")) {
            return 0;
        }
        LocalDate startDate = LocalDate.parse(dateOfStartingMembership, dateTimeFormatter);
        LocalDate endDate = LocalDate.parse(dateOfEndingMembership, dateTimeFormatter);
        if (startDate.getYear() != endDate.getYear()) {
            startDate = newYear;
        }
        return startDate.until(endDate).getMonths();
    }

    public static boolean isLegal(String dateOfBirth) {
        try {
            return dateOfBirth.substring(dateOfBirth.lastIndexOf("/") + 1).length() == 4;
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    }


}
