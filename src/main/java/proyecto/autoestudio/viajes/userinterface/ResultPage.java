package proyecto.autoestudio.viajes.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import proyecto.autoestudio.viajes.utils.GeneralConstants;

public class ResultPage {

  public static final Target LIST_PRICE = Target.the("List of Prices").locatedBy(
      "//section[@class='item-list clearfix']//strong[@data-qa='recommended-price'][contains(text(), '$')]");
  public static final Target BUTTON_VIEW_DEAL = Target.the("Button view deal").locatedBy(
      "//meta[@content='{0}']//ancestor::div[@data-qa='recommended-deal-area']//child::button");
  public static final Target LABEL_HOTEL = Target.the("Label hotel").locatedBy(
      "//meta[@content='{0}']//ancestor::div[@class='item__flex-column']//child::span[@class='item-link name__copytext']");
  public static final Target LABEL_NAME_HOTEL = Target.the("Label name hotel")
        .locatedBy("//h1[@class='page-header-title']");
  public static final Target LABEL_NAME_HOTEL_SECOND_OPTION = Target.the("Label name hotel")
      .locatedBy("(//*[contains(text(), '{0}')])[1]");

  private ResultPage() {
    throw new IllegalStateException(GeneralConstants.UTILITY_CLASS);
  }
}

