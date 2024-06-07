package hei.school.affirmations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public sealed class Affirmation permits Vérité , Mensonge{
  protected String texte;

  public ValeurDevérité getValeur() {
    return ValeurDevérité.JENESAISPAS;
  }

  public static enum ValeurDevérité {
    VRAI,
    FAUX,
    JENESAISPAS
  }


}
