package test_fonctionnel;

import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
    public static void main(String[] args) {
        Gaulois asterix = new Gaulois("Asterix", 8);
        Romain minus = new Romain("Minus", 6);

        System.out.println(asterix.getNom());
        asterix.parler("Bonjour à tous");
        minus.parler("UN GAU… UN GAUGAU…");

        // minus.recevoirCoup(3);
        // minus.recevoirCoup(3);

        asterix.frapper(minus);
        minus.frapper(asterix);
        asterix.frapper(minus);
        minus.frapper(asterix);
        asterix.frapper(minus);	
    }
}
