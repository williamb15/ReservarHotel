package proyecto.autoestudio.viajes.task;

import static proyecto.autoestudio.viajes.utils.NumberConstants.*;
import static proyecto.autoestudio.viajes.utils.HotelConstants.*;

import net.thucydides.core.annotations.Step;
import proyecto.autoestudio.viajes.interactions.SwitchTo;
import proyecto.autoestudio.viajes.interactions.WaitInteraction;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import proyecto.autoestudio.viajes.userinterface.ResultPage;
import proyecto.autoestudio.viajes.utils.SearchPrice;

public class AnalyzeResult implements Interaction {

    private String nameHotel;

    public String getNameHotel() {
        return nameHotel;
    }

    @Step("{0} Analyst Results")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade element = SearchPrice.wanted(ResultPage.LIST_PRICE.resolveAllFor(actor));
        String price =element.getText().replace(SYMBOL_PESO,SPACE).replace(POINT,SPACE);
        nameHotel= Text.of(ResultPage.LABEL_HOTEL.of(price)).viewedBy(actor).asString();

        actor.attemptsTo(WaitInteraction.waitClass(FIVE),
            Click.on(ResultPage.BUTTON_VIEW_DEAL.of(price)),
            WaitInteraction.waitClass(TWO),
            SwitchTo.browserTab(nameHotel),
            WaitInteraction.waitClass(FIVE));
    }
    public static AnalyzeResult ofTheList(){
        return Tasks.instrumented(AnalyzeResult.class);
    }
}
