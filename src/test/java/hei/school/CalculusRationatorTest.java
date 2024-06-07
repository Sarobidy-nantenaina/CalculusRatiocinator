package hei.school;

import static org.junit.jupiter.api.Assertions.assertEquals;
import hei.school.affirmations.Affirmation;
import hei.school.affirmations.Mensonge;
import hei.school.affirmations.Vérité;
import hei.school.affirmations.conjonctioDeCoordination.Donc;
import hei.school.affirmations.conjonctioDeCoordination.Et;
import hei.school.affirmations.conjonctioDeCoordination.Ou;
import org.junit.jupiter.api.Test;

public class CalculusRationatorTest {

  private static final Affirmation verite = new Vérité("Lou est beau.");
  private static final Affirmation mensonge = new Mensonge("Lou est pauvre.");
  private static final Affirmation affirmation = new Affirmation("Lou est généreux.");

  @Test
  public void testAffirmation1() {
    Affirmation.ValeurDevérité resultat = new Et(verite.getValeur(), affirmation.getValeur()).évaluer();
    assertEquals(Affirmation.ValeurDevérité.FAUX, resultat);
  }

  @Test
  public void testAffirmation2() {
    Affirmation.ValeurDevérité resultat = new Donc(verite.getValeur(), mensonge.getValeur()).évaluer();
    assertEquals(Affirmation.ValeurDevérité.FAUX, resultat);
  }

  @Test
  public void testAffirmation3() {
    Affirmation.ValeurDevérité resultat = new Donc(mensonge.getValeur(), affirmation.getValeur()).évaluer();
    assertEquals(Affirmation.ValeurDevérité.VRAI, resultat);
  }

  @Test
  public void testAffirmation4() {
    Affirmation.ValeurDevérité resultat = new Donc(new Ou(verite.getValeur(), affirmation.getValeur()).évaluer(), mensonge.getValeur()).évaluer();
    assertEquals(Affirmation.ValeurDevérité.FAUX, resultat);
  }

  @Test
  public void testAffirmation5() {
    Affirmation.ValeurDevérité resultat1 = new Ou(verite.getValeur(), affirmation.getValeur()).évaluer();
    Affirmation.ValeurDevérité resultat2 = new Ou(mensonge.getValeur(), affirmation.getValeur()).évaluer();

    assertEquals(resultat1, resultat2);
  }


}
