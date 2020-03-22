package proyecto.autoestudio.viajes.exceptions;

import proyecto.autoestudio.viajes.utils.ErrorsConstants;

@SuppressWarnings("serial")
public class SearchHotelExceptions extends AssertionError {
  public SearchHotelExceptions(String message, Throwable cause) {
    super(ErrorsConstants.FAILED_SEARCH_TRAVEL);
  }
}
