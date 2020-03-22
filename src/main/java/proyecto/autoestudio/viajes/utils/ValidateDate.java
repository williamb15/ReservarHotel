package proyecto.autoestudio.viajes.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateDate {

  private static final Logger LOGGER = LoggerFactory.getLogger(ValidateDate.class);
  private static GregorianCalendar currentDate = new GregorianCalendar();
  private static int currentYear = currentDate.get(Calendar.YEAR);
  private static int currentMonth = currentDate.get(Calendar.MONTH);
  private static int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
  private static boolean dateOK;

  private ValidateDate() {
  }

  public static ValidateDate date(GregorianCalendar date) {

    int year = date.get(Calendar.DAY_OF_MONTH);
    int month = date.get(Calendar.DAY_OF_MONTH);
    int day = date.get(Calendar.DAY_OF_MONTH);

    if (currentYear > year) {
      LOGGER.info(ErrorsConstants.ERROR_YEAR);
      dateOK = false;
    } else {
      dateOK = true;
    }
    if (currentYear == year && currentMonth > month) {
      LOGGER.info(ErrorsConstants.ERROR_MONTH);
      dateOK = false;
    } else {
      dateOK = true;
    }
    if (currentMonth == month && currentDay > day) {
      LOGGER.info(ErrorsConstants.ERROR_DAY);
      dateOK = false;
    } else {
      dateOK = true;
    }
    return new ValidateDate();
  }

  public static boolean isDateOK() {
    return dateOK;
  }
}
