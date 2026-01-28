package personnages;

import java.security.SecureRandom;
import java.util.Random;

public class Druide extends Gaulois{
	private int nbDoses =0 ;
	private int forcePotion ; 
	private Random random;

	public Druide(String nom, int force) {
		super(nom, force);
		try {
			 random = SecureRandom.getInstanceStrong();
			} catch (Exception e) {
			 e.printStackTrace();
			}
	}
	public void creationDoses(int Doses) {
		this.nbDoses = nbDoses+ Doses;
		this.forcePotion=2 + random.nextInt(5) ;
		parler("J'ai concocté "+ nbDoses +" doses de potions magique. Elle a une force de "+forcePotion +" .");
		
	}
	public void booster(Gaulois gaulois) {
			if (Gaulois gaulois=obelix) {
				parler("pas de popo pour toi mon gourmand");
			}
	}
}
