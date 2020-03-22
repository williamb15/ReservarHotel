package proyecto.autoestudio.viajes.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.targets.Target;
import proyecto.autoestudio.viajes.task.AnalyzeResult;

public class ValidateName implements Question {

  private Target labelNameActivity;
  private Target labelNameActivitySecondOption;

  public ValidateName(Target labelNameActivity, Target labelNameActivitySecondOption) {
    this.labelNameActivity = labelNameActivity;
    this.labelNameActivitySecondOption=labelNameActivitySecondOption;
  }

  public static ValidateName ofTheHotel(Target labelNameActivity, Target labelNameActivitySecondOption) {
    return new ValidateName(labelNameActivity, labelNameActivitySecondOption);
  }

  @Override
  public Object answeredBy(Actor actor) {
    String nameHotel=AnalyzeResult.ofTheList().getNameHotel();
    if (labelNameActivity.resolveFor(actor).isVisible()){
      return CurrentVisibility.of(labelNameActivity).viewedBy(actor).asBoolean();
    }else {
      return CurrentVisibility.of(labelNameActivitySecondOption.of(nameHotel)).viewedBy(actor).asBoolean();
    }
  }
}
