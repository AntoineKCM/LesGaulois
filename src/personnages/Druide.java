package personnages;

import java.security.SecureRandom;
import java.util.Random;

public class Druide extends Gaulois {

    private int nbDoses = 0;
    private double forcePotion;
    private Random random;

    public Druide(String nom, int force) {
        super(nom, force);
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void creationDoses(int doses) {
        nbDoses += doses;
        forcePotion = 2 + random.nextInt(5);
        parler("J'ai concocté " + nbDoses +
               " doses de potion magique. Elle a une force de " +
               forcePotion + ".");
    }

    public void booster(Gaulois gaulois) {

        if (nbDoses <= 0) {
            parler("Désolé " + gaulois.getNom() +
                   " il n'y a plus une seule goutte de potion.");
            return;
        }

        if (gaulois.getNom().equals("Obelix")) {
            parler("Non, Obélix non !... Et tu le sais très bien !");
            return;
        }

        parler("Tiens " + gaulois.getNom() + " un peu de potion magique.");
        gaulois.setBoost(forcePotion);
        nbDoses--;
    }
}
