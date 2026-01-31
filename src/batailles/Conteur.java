package batailles;

public class Conteur {
    private String nom;

    public Conteur(String nom) {
        this.nom = nom;
    }

    public void raconter(IBataille bataille) {
        System.out.println("Je suis " + nom + ". Je vais vous conter une histoire qui se déroule en 50 avant Jésus-Christ,");
        System.out.println("du temps où la Gaule est occupée par les Romains.\n");

        System.out.println(bataille.decrireContexte());
        System.out.println(bataille.choisirCombattants());
        System.out.println(bataille.preparerCombat());
        System.out.println(bataille.decrireCombat());
        System.out.println(bataille.donnerResultat());
    }
}
