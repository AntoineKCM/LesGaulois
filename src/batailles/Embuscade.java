package batailles;

import personnages.Equipement;
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
        Soldat[] soldats = selectionnerSoldats();
        String texte = "Les soldats s'étaient bien préparés :\n";

        for (int i = 0; i < soldats.length; i++) {
            Soldat s = soldats[i];
            s.equiper(Equipement.CASQUE);
            texte += "- Le soldat " + s.getNom() + " s'équipe avec un casque.\n";

            s.equiper(Equipement.PLASTRON);
            texte += "- Le soldat " + s.getNom() + " s'équipe avec un plastron.\n";

            s.equiper(Equipement.BOUCLIER);
            texte += "- Le soldat " + s.getNom() + " s'équipe avec un bouclier.\n";
        }
        return texte;
    }

    private Soldat choisirSoldatVivant(Soldat[] soldats) {
        int i = (int)(Math.random() * soldats.length);
        while (!soldats[i].estVivant()) {
            i = (int)(Math.random() * soldats.length);
        }
        return soldats[i];
    }

    private Gaulois choisirGauloisVivant(Gaulois[] gaulois) {
        int i = (int)(Math.random() * gaulois.length);
        while (!gaulois[i].estVivant()) {
            i = (int)(Math.random() * gaulois.length);
        }
        return gaulois[i];
    }

    @Override
    public String decrireCombat() {
        Gaulois[] gaulois = selectionnerPromeneurs();
        Soldat[] soldats = selectionnerSoldats();

        String texte = "";

        while (!equipeKO(gaulois) && !equipeKO(soldats)) {
            Gaulois g = choisirGauloisVivant(gaulois);
            Soldat s = choisirSoldatVivant(soldats);

            if (Math.random() < 0.5) {
                texte += "Le gaulois " + g.getNom() +
                         " donne un grand coup au soldat " + s.getNom() + ".\n";
                g.frapper(s);
                texte += "Le soldat " + s.getNom() + " : « Aïe ».\n";
            } else {
                texte += "Le soldat " + s.getNom() +
                        " donne un grand coup au gaulois " + g.getNom() + ".\n";
                s.frapper(g);
                texte += "Le gaulois " + g.getNom() + " : « Aïe ».\n";
            }
        }
        return texte;
    }

    @Override
    public String donnerResultat() {
        Gaulois[] gaulois = selectionnerPromeneurs();
        if (!equipeKO(gaulois)) {
            return "Malgré cette sournoise attaque, nos promeneurs s'en sont sortis indemnes.\n" +
                   "Ils pouvaient compter sur la force de " + formatterGaulois(gaulois);
        } else {
            return "L'attaque fut tellement rapide et inattendue que nos malheureux gaulois n'ont pas eu le temps de réagir.\n" +
                   "Ils furent ligotés et emmenés dans le camp de " + camp.getCommandant().getNom() + ".";
        }
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

    private boolean equipeKO(Gaulois[] gaulois) {
        for (int i = 0; i < gaulois.length; i++) {
            if (gaulois[i].estVivant()) return false;
        }
        return true;
    }

    private boolean equipeKO(Soldat[] soldats) {
        for (int i = 0; i < soldats.length; i++) {
            if (soldats[i].estVivant()) return false;
        }
        return true;
    }

    private String formatterGaulois(Gaulois[] gaulois) {
        String texte = "";
        int nb = 0;

        for (int i = 0; i < gaulois.length; i++) {
            if (gaulois[i] != null && gaulois[i].estVivant()) nb++;
        }

        int compteur = 0;
        for (int i = 0; i < gaulois.length; i++) {
            if (gaulois[i] != null && gaulois[i].estVivant()) {
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
        int nb = 0;

        for (int i = 0; i < soldats.length; i++) {
            if (soldats[i] != null) nb++;
        }

        int compteur = 0;
        for (int i = 0; i < soldats.length; i++) {
            if (soldats[i] != null) {
                if (!texte.isEmpty()) {
                    texte += (compteur == nb - 1 ? " et " : ", ");
                }
                texte += soldats[i].getNom();
                compteur++;
            }
        }
        return texte + ".";
    }
}
