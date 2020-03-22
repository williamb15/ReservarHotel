package proyecto.autoestudio.viajes.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import proyecto.autoestudio.viajes.utils.GeneralConstants;

public class SearchPage {

  public static final Target DESTINY = Target.the("Add destiny")
      .located(By.xpath("//input[@class='js-query input querytext']"));
  public static final Target DESTINY_LIST = Target.the("Add destiny list")
      .located(By.xpath("(//div[@class='ssg-suggestion__info'])[1]"));
  public static final Target ARRIVAL = Target.the("Add arrival")
      .located(By.xpath("//span[contains(text(),'Llegada')]"));
  public static final Target EXIT = Target.the("Add exit")
      .located(By.xpath("//span[contains(text(),'Salida')]"));
  public static final Target TYPE_ROOM = Target.the("Add destiny")
      .located(By.xpath("//span[@class='dealform-button__label']"));
  public static final Target BUTTON_SEARCH = Target.the("Button Search")
      .located(By.xpath("//span[@class='search-button__label']"));
  public static final Target NEXT_MONTH = Target.the("Button next month")
      .located(By.xpath("//span[@class='icon-ic cal-btn-ic icon-rtl']"));
  public static final Target SELECT_DAY = Target.the("Select Day")
      .locatedBy("//time[@datetime='{0}']");
  public static final Target SELECT_TYPE_ROOM = Target.the("Select type Room")
      .locatedBy("//span[@class='roomtype-btn__label'][contains(text(),'{0}')]");

  private SearchPage() {
    throw new IllegalStateException(GeneralConstants.UTILITY_CLASS);
  }
}