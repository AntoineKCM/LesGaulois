package batailles;

import personnages.Gaulois;
import personnages.Soldat;
import personnages.Grades;
import sites.Village;
import sites.Camp;

public class Embuscade implements IBataille {

    private Village village;
    private Camp camp;

    public Embuscade(Village village, Camp camp) {
        this.village = village;
        this.camp = camp;
    }

    @Override
    public String decrireContexte() {
        return "Dans une sombre forêt dans un coin reculé de la Gaule, quatre comparses se promènent.";
    }

    @Override
    public String choisirCombattants() {
        Gaulois[] promeneurs = selectionnerPromeneurs();
        Soldat[] embusques = selectionnerSoldats();

        return "Il s'agit de " + formatterGaulois(promeneurs) +
               "\nMais cachés derrière des bosquets se cachent " + formatterSoldats(embusques);
    }

    @Override
    public String preparerCombat() {
        Soldat[] embusques = selectionnerSoldats();
        String texte = "";

        for (int i = 0; i < embusques.length; i++) {
            texte += "Le soldat " + embusques[i].getNom() + " s'équipe de ses protections.\n";
        }
        return texte;
    }

    @Override
    public String decrireCombat() {
        return "Les gaulois sont surpris par l'embuscade et n'ont pas bu de potion magique.";
    }

    @Override
    public String donnerResultat() {
        return "Les soldats prennent l'avantage grâce à l'effet de surprise.";
    }


    private Gaulois[] selectionnerPromeneurs() {
        Gaulois[] villageois = village.getVillageois();
        int nb = village.getNbVillageois();

        Gaulois[] promeneurs = new Gaulois[4];
        for (int i = 0; i < 4 && i < nb; i++) {
            promeneurs[i] = villageois[i];
        }
        return promeneurs;
    }

    private Soldat[] selectionnerSoldats() {
        Soldat[] soldats = camp.getSoldats();
        int nb = camp.getNbSoldats();

        Soldat[] resultat = new Soldat[2];
        int indice = 0;

        for (int i = 0; i < nb && indice < 2; i++) {
            if (soldats[i].getGrade() == Grades.SOLDAT) {
                resultat[indice] = soldats[i];
                indice++;
            }
        }
        return resultat;
    }

    private String formatterGaulois(Gaulois[] gaulois) {
        String texte = "";
        int nb = 0;

        for (int i = 0; i < gaulois.length; i++) {
            if (gaulois[i] != null) nb++;
        }

        int compteur = 0;
        for (int i = 0; i < gaulois.length; i++) {
            if (gaulois[i] != null) {
                if (!texte.isEmpty()) {
                    texte += (compteur == nb - 1 ? " et " : ", ");
                }
                texte += gaulois[i].getNom();
                compteur++;
            }
        }
        return texte + ".";
    }

    private String formatterSoldats(Soldat[] soldats) {
        String texte = "";

        for (int i = 0; i < soldats.length; i++) {
            if (soldats[i] != null) {
                if (!texte.isEmpty()) {
                    texte += " et ";
                }
                texte += soldats[i].getNom();
            }
        }
        return texte + ".";
    }
}
