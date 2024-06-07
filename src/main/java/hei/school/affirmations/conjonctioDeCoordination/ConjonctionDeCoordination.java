package hei.school.affirmations.conjonctioDeCoordination;
import hei.school.affirmations.Affirmation;

public abstract sealed class ConjonctionDeCoordination permits Et,Donc,Ou{
  protected Affirmation.ValeurDevérité a;
  protected Affirmation.ValeurDevérité b;

  public ConjonctionDeCoordination(Affirmation.ValeurDevérité a, Affirmation.ValeurDevérité b) {
    this.a = a;
    this.b = b;
  }

  public abstract Affirmation.ValeurDevérité évaluer();
}

