package hei.school.affirmations;

public final class Vérité extends Affirmation {
  public Vérité(String texte) {
    super(texte);
  }

  @Override
  public ValeurDevérité getValeur() {
    return ValeurDevérité.VRAI;
  }

}
