package proyecto.autoestudio.viajes.utils;

import static proyecto.autoestudio.viajes.utils.NumberConstants.*;
import static proyecto.autoestudio.viajes.utils.HotelConstants.*;

import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchPrice {

    private SearchPrice() {
    }

    public static WebElementFacade wanted(List<WebElementFacade> listPrices) {

        int lowerPrice = NINE_HUNDRED_NINETY_NINE_THOUSAND;
        int index = ZERO;

        for (int i = ZERO; i < listPrices.size(); i++) {
            int price = Integer.parseInt(
                listPrices.get(i).getText().replace(SYMBOL_PESO, "").replace(POINT, "").trim());
            if (lowerPrice>price){
                lowerPrice= price;
                index= i;
            }
        }

        return listPrices.get(index);
    }
}

