package hei.school;

import hei.school.affirmations.Affirmation;
import hei.school.affirmations.conjonctioDeCoordination.ConjonctionDeCoordination;
import hei.school.affirmations.conjonctioDeCoordination.Donc;
import hei.school.affirmations.conjonctioDeCoordination.Et;
import hei.school.affirmations.conjonctioDeCoordination.Ou;


public record CalculusRacionator() {

  public static Affirmation[] découper(String texte) {
    String[] parties = texte.split("(?i)( et | ou | donc )", 2);

    Affirmation[] affirmations = new Affirmation[2];
    affirmations[0] = new Affirmation(parties[0]);
    affirmations[1] = new Affirmation(parties[1]);

    return affirmations;
  }

  public static Affirmation.ValeurDevérité calculer(String texte) {
    Affirmation[] affirmations = découper(texte);

    Affirmation.ValeurDevérité valeurA = affirmations[0].getValeur();
    Affirmation.ValeurDevérité valeurB = affirmations[1].getValeur();

    ConjonctionDeCoordination conjonction = null;

    if (texte.contains(" et ")) {
      conjonction = new Et(valeurA, valeurB);
    } else if (texte.contains(" ou ")) {
      conjonction = new Ou(valeurA, valeurB);
    } else if (texte.contains(" donc ")) {
      conjonction = new Donc(valeurA, valeurB);
    }

    if (conjonction != null) {
      return conjonction.évaluer();
    } else {
      return Affirmation.ValeurDevérité.JENESAISPAS;
    }
  }
}
