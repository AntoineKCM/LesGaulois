package test_fonctionnel;
import personnages.*;

public class TestGaulois {

    public static void main(String[] args) {

        Gaulois asterix = new Gaulois("Asterix", 5);
        Soldat minus = new Soldat("Minus", 6, Grades.SOLDAT);
        Druide panoramix = new Druide("Panoramix", 5);
        Gaulois obelix = new Gaulois("Obelix", 10);
        Gaulois assurancetourix = new Gaulois("Assurancetourix", 2);
        Gaulois abraracourcix = new Gaulois("Abraracourcix", 3);
        Gaulois agecanonix = new Gaulois("Agecanonix", 4);

        minus.equiper(Equipement.BOUCLIER);
        minus.equiper(Equipement.CASQUE);
        minus.equiper(Equipement.PLASTRON);

        panoramix.creationDoses(3);
        panoramix.booster(asterix);
        panoramix.booster(obelix);
        panoramix.booster(assurancetourix);
        panoramix.booster(abraracourcix);
        panoramix.booster(agecanonix);

        asterix.parler("Bonjour à tous");
        minus.parler("UN GAU... UN GAUGAU...");

        while (asterix.estVivant() && minus.estVivant()) {
            asterix.frapper(minus);
            if (minus.estVivant()) {
                minus.frapper(asterix);
            }
        }
    }
}

