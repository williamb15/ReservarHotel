package proyecto.autoestudio.viajes.models;

import java.util.GregorianCalendar;

public class TravelFeatures {

  private String destiny;
  private GregorianCalendar arrivalDate;
  private GregorianCalendar exitDate;
  private String room;

  public TravelFeatures(String destiny, GregorianCalendar arrivalDate, GregorianCalendar exitDate,
      String room) {
    this.destiny = destiny;
    this.arrivalDate = arrivalDate;
    this.exitDate = exitDate;
    this.room = room;
  }

  public String getDestiny() {
    return destiny;
  }

  public GregorianCalendar getArrivalDate() {
    return arrivalDate;
  }

  public GregorianCalendar getExitDate() {
    return exitDate;
  }

  public String getRoom() {
    return room;
  }
}
