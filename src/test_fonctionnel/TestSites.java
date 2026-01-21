package test_fonctionnel;

import personnages.*;
import sites.*;

public class TestSites {

    public static void main(String[] args) {

        Gaulois vercingetorix = new Gaulois("Vercingétorix", 5);
        Gaulois agecanonix = new Gaulois("Agecanonix", 1);
        Gaulois assurancetourix = new Gaulois("Assurancetourix", 2);
        Gaulois asterix = new Gaulois("Astérix", 5);
        Gaulois obelix = new Gaulois("Obelix", 15);
        Gaulois prolix = new Gaulois("Prolix", 2);
        Gaulois abraracourcix = new Gaulois("Abraracourcix", 5);
        
        Village village = new Village(vercingetorix);

        
        Soldat minus = new Soldat("Minus", 2, Grades.SOLDAT);
        Soldat brutus = new Soldat("Brutus", 5, Grades.CENTURION);
        Soldat milexcus = new Soldat("Milexcus", 2, Grades.SOLDAT);
        Soldat tulliusOctopus = new Soldat(" Tullius Octopus", 2, Grades.TESSERARIUS);
        Soldat ballondebaudrus = new Soldat("Ballondebaudrus", 3, Grades.OPTIO);
        Soldat briseradius = new Soldat("Briseradius", 4, Grades.SOLDAT);
        Soldat chorus = new Soldat("Chorus", 4, Grades.CENTURION);
        
        Camp camp = new Camp(minus);
        

        
        camp.ajouterSoldat(brutus);
        camp.ajouterSoldat(milexcus);
        camp.ajouterSoldat(tulliusOctopus);
        camp.ajouterSoldat(ballondebaudrus);   
        camp.ajouterSoldat(briseradius);
        camp.ajouterSoldat(chorus);
        
        village.ajouterVillageois(abraracourcix);
        village.ajouterVillageois(agecanonix);
        village.ajouterVillageois(assurancetourix);
        village.ajouterVillageois(asterix);
        village.ajouterVillageois(obelix);
        village.ajouterVillageois(prolix);
        
        village.afficherVillageois();
        camp.afficherCamp();
        
        village.changerChef(abraracourcix);
        
        camp.changerCommandant(briseradius);
        camp.changerCommandant(chorus);
        
        
    }
}
