package personnages;

public class Gaulois extends Personnage {
    private double boost = 1.0;
    private int forceInitiale;

    public Gaulois(String nom, int force) {
        super(nom, force);
        this.forceInitiale = force;
    }

    @Override
    protected String donnerAuteur() {
        return "Le gaulois " + getNom();
    }

    @Override
    public void frapper(Personnage adversaire) {
        double forceEffective = Math.max(boost, 1.0);
        int forceCoup = (int)(forceInitiale * forceEffective);

        System.out.println(donnerAuteur() +
                " donne un grand coup de force " + forceCoup +
                " au " + adversaire.getNom());

        adversaire.recevoirCoup(forceCoup);

        if (boost > 1) {
            boost -= 0.5;
        }
    }

    public void setBoost(double boost) {
        this.boost = boost;
    }
}
