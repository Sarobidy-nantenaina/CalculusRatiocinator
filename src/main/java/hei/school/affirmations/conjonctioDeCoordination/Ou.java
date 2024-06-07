package hei.school.affirmations.conjonctioDeCoordination;

import hei.school.affirmations.Affirmation;

public class Ou extends ConjonctionDeCoordination {

  public Ou(Affirmation.ValeurDevérité a, Affirmation.ValeurDevérité b) {
    super(a, b);
  }

  @Override
  public Affirmation.ValeurDevérité évaluer() {
    if (a == Affirmation.ValeurDevérité.VRAI || b == Affirmation.ValeurDevérité.VRAI) {
      return Affirmation.ValeurDevérité.VRAI;
    } else if (a == Affirmation.ValeurDevérité.FAUX && b == Affirmation.ValeurDevérité.FAUX) {
      return Affirmation.ValeurDevérité.FAUX;
    } else {
      return Affirmation.ValeurDevérité.JENESAISPAS;
    }
  }
}
