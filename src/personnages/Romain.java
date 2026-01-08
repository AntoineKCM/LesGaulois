package personnages;

public class Romain {
	private String nom ;
	private int force ;
	
	
	
	public Romain(String nom,int force) {
		this.nom = nom ;
		this.force = force ;
	}
	public String getNom() {
		return nom ; 
	}
	
	
	public void parler(String texte) {
		System.out.println("Le Romain " + nom + " : « " + texte + " ».");
	}
	public void recevoirCoup(int forcecoup) {
		if(forcecoup>=force) {
			force =0 ; 
			System.out.println("Le Romain " + nom + " : « "+"« J’abandonne…"+ " ».");
		}
		else {
			force =force - forcecoup ;
			System.out.println("Le Romain " + nom + " : « "+"Aïe ! "+ " ».") ;
		}
	}
}
