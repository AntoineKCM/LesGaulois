package personnages;

public abstract class Personnage {

    private String nom;
    protected int force; 

    public Personnage(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(donnerAuteur() + " : " + texte);
    }

    protected abstract String donnerAuteur();

    public void frapper(Personnage adversaire) {
        System.out.println(donnerAuteur() + " envoie un grand coup dans la mâchoire de " + adversaire.getNom());
        adversaire.recevoirCoup(force);
    }

    public void recevoirCoup(int forceCoup) {
        if (forceCoup >= force) {
            force = 0;
            System.out.println(donnerAuteur() + " : « J’abandonne… »");
        } else {
            force -= forceCoup;
            System.out.println(donnerAuteur() + " : « Aïe ! »");
        }
    }

    public boolean estVivant() {
        return force > 0;
    }
}
