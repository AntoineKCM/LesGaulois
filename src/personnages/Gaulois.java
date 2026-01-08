package personnages;

public class Gaulois {
	private String nom ;
	private int force ;
	
	public Gaulois(String nom,int force) {
		this.nom = nom ;
		this.force = force ;
	}
	public String getNom() {
		return nom ; 
	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		System.out.println(asterix.getNom());		
	}
	
	public void parler(String texte) {
		System.out.println("Le Gaulois " + nom + " : « " + texte + " ».");
	}
	public void frapper(Romain rom) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain );
		romain.recevoirCoup(force/3)
	}
}
