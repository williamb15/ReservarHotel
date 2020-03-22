package proyecto.autoestudio.viajes.interactions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static proyecto.autoestudio.viajes.utils.NumberConstants.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import proyecto.autoestudio.viajes.userinterface.SearchPage;
import proyecto.autoestudio.viajes.utils.GeneralConstants;
import proyecto.autoestudio.viajes.utils.HotelConstants;
import proyecto.autoestudio.viajes.utils.ValidateDate;

public class SelectDate implements Interaction {

  private Calendar currentDate = new GregorianCalendar();
  private GregorianCalendar travelDate;
  private Target target;

  public SelectDate(GregorianCalendar travelDate, Target target) {
    this.travelDate = travelDate;
    this.target=target;
  }

  public static SelectDate forTheTravel(GregorianCalendar travelDate, Target target) {
    return Tasks.instrumented(SelectDate.class, travelDate, target);
  }

  @Step("{0} Select the date #travelDate")
  @Override
  public <T extends Actor> void performAs(T actor) {
    int currentMonth;
    int month;
    int clicks;

    ValidateDate.date(travelDate);
    SimpleDateFormat formatter = new SimpleDateFormat(GeneralConstants.FORMAT_DATE);
    String formattedDate = formatter.format(travelDate.getTime());

    if (target.toString().contains(HotelConstants.ARRIVAL)){
      currentMonth=(currentDate.get(Calendar.MONTH)) + ONE;
      month=(travelDate.get(Calendar.MONTH))+ ONE;
      actor.attemptsTo(WaitUntil.the(target, isEnabled()),
          Click.on(target),
          Click.on(target),
          WaitInteraction.waitClass(TWO));
      if(ValidateDate.isDateOK()){
        if (currentMonth < month) {
          clicks = month-currentMonth;
          for(int i=ZERO; i<clicks; i++){
            actor.attemptsTo(Click.on(SearchPage.NEXT_MONTH));
          }
        }
        actor.attemptsTo(WaitInteraction.waitClass(TWO),
            Click.on(SearchPage.SELECT_DAY.of(formattedDate)));
      }
    }else {
      actor.attemptsTo(WaitInteraction.waitClass(TWO),
          Click.on(SearchPage.SELECT_DAY.of(formattedDate)));
    }
  }
}
