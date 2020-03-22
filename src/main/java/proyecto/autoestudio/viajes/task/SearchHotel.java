package proyecto.autoestudio.viajes.task;

import static proyecto.autoestudio.viajes.utils.NumberConstants.ONE;
import static proyecto.autoestudio.viajes.utils.NumberConstants.ZERO;

import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import proyecto.autoestudio.viajes.interactions.SelectDate;
import proyecto.autoestudio.viajes.interactions.WaitInteraction;
import proyecto.autoestudio.viajes.models.TravelFeatures;
import proyecto.autoestudio.viajes.userinterface.SearchPage;

public class SearchHotel implements Task {

  private List<TravelFeatures> list;

  public SearchHotel(List<TravelFeatures> listData) {
    this.list = listData;
  }

  public static SearchHotel withData(List<TravelFeatures> list) {
    return Tasks.instrumented(SearchHotel.class, list);
  }

  @Step("{0} Search Travel for #list.get(ZERO).getDestiny()")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(list.get(ZERO).getDestiny()).into(SearchPage.DESTINY),
        Click.on(SearchPage.DESTINY_LIST),
        WaitInteraction.waitClass(ONE),
        SelectDate.forTheTravel(list.get(ZERO).getArrivalDate(), SearchPage.ARRIVAL),
        SelectDate.forTheTravel(list.get(ZERO).getExitDate(), SearchPage.EXIT),
        Click.on(SearchPage.TYPE_ROOM),
        Click.on(SearchPage.TYPE_ROOM),
        Click.on(SearchPage.SELECT_TYPE_ROOM.of(list.get(ZERO).getRoom())),
        WaitInteraction.waitClass(ONE),
        Click.on(SearchPage.BUTTON_SEARCH));
  }
}
