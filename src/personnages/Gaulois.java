package personnages;

public class Gaulois extends Personnage {

    public Gaulois(String nom, int force,int boost) {
        super(nom, force);
        boost = 1 ;
    }

    @Override
    protected String donnerAuteur() {
        return "Le gaulois " + getNom();
    }
    @Override
    public void frapper(Personnage adversaire) {
	    System.out.println(donnerAuteur() + " envoie un grand coup dans la mâchoire de " + adversaire.getNom());
	    adversaire.recevoirCoup(force / 3);
	    if (boost !=1 ) {
	    	boost =boost - 0.5 ;
	    }
	}
}
