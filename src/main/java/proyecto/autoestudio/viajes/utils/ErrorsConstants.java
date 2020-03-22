package proyecto.autoestudio.viajes.utils;

public class ErrorsConstants {

  public static final String ERROR_YEAR = "The date cannot be earlier than the current one (check year)";
  public static final String ERROR_MONTH = "The date cannot be earlier than the current one (check month)";
  public static final String ERROR_DAY = "The date cannot be earlier than the current one (check day)";
  public static final String FAILED_SEARCH_TRAVEL = "The hotel search transaction did not complete successfully";

  private ErrorsConstants() {
    throw new IllegalStateException(GeneralConstants.UTILITY_CLASS);
  }
}
