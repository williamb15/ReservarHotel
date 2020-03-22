package proyecto.autoestudio.viajes.interactions;

import static proyecto.autoestudio.viajes.utils.NumberConstants.FIVE;
import static proyecto.autoestudio.viajes.utils.NumberConstants.ZERO;

import java.util.Set;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import proyecto.autoestudio.viajes.utils.HotelConstants;

public class SwitchTo implements Interaction {

  private String nameBrowserTab;

  public SwitchTo(String nameBrowserTab) {
    this.nameBrowserTab = nameBrowserTab;
  }

  public static SwitchTo browserTab(String nameBrowserTab) {
    return Tasks.instrumented(SwitchTo.class, nameBrowserTab);
  }

  @Step("{0} Switch to Browser tab #nameBrowserTab")
  @Override
  public <T extends Actor> void performAs(T actor) {
    Set<String> browserTabs = BrowseTheWeb.as(actor).getDriver().getWindowHandles();
    nameBrowserTab = HotelConstants.HOTEL + nameBrowserTab;
    for (String browserTab : browserTabs) {
      BrowseTheWeb.as(actor).getDriver().switchTo().window(browserTab);
      if (BrowseTheWeb.as(actor).getDriver().getTitle().substring(ZERO, FIVE)
          .contains(nameBrowserTab)) {
        break;
      }
    }
  }
}
