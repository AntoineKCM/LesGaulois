package sites;

import personnages.Grades;
import personnages.Soldat;

public class Camp {

    private Soldat commandant;
    private Soldat[] soldats;
    private int nbSoldats;

    public Camp(Soldat commandant) {
        this.commandant = commandant;
        this.soldats = new Soldat[5];
        this.nbSoldats = 0;

        commandant.parler("Je suis en charge de créer un nouveau camp romain.");
    }

    public Soldat getCommandant() {
        return commandant;
    }

    public void ajouterSoldat(Soldat soldat) {
        if (nbSoldats < 5) {
            soldats[nbSoldats] = soldat;
            nbSoldats++;
            soldat.parler("Je mets mon épée au service de Rome dans le camp dirigé par "+ commandant.getNom());
        }
        else {
            commandant.parler("Désolé "+ soldat.getNom()+" notre camp est complet !");
            }
        }
    public void afficherCamp() {
		System.out.println("Le camp dirigé par "+ commandant.getNom() +"contient les soldats :  ");
		for (int i = 0; i < nbSoldats; i++) {
			System.out.println("-" + soldats[i].getNom());
		        }
    }
    
    public void changerCommandant(Soldat nouveauCommandant) {
        if (nouveauCommandant.getGrade() != Grades.CENTURION) {
            nouveauCommandant.parler(
                "Je ne suis pas suffisamment gradé pour prendre la direction du camp romain."
            );
        } else {
            nouveauCommandant.parler(
                "Moi " + nouveauCommandant.getNom() + " je prends la direction du camp romain."
            );
            commandant = nouveauCommandant;
        }
    }

}
    	
	