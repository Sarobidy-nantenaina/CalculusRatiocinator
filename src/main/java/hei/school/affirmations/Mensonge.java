package hei.school.affirmations;

public final class Mensonge extends Affirmation {

  public Mensonge(String texte) {
    super(texte);
  }

  @Override
  public ValeurDevérité getValeur() {
    return ValeurDevérité.FAUX;
  }
}
