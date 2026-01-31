package personnages;

public class Soldat extends Romain {
    private Grades grade;
    private Equipement casque;
    private Equipement plastron;
    private Equipement bouclier;

    public Soldat(String nom, int force, Grades grade) {
        super(nom, force);
        this.grade = grade;
    }
    public Grades getGrade() {
        return grade;
    }
    public void equiper(Equipement e) {
        if (e == Equipement.CASQUE && casque == null) {
            casque = e;
            System.out.println("Le soldat " + getNom() + " s'équipe avec un casque.");
        }
        if (e == Equipement.PLASTRON && plastron == null) {
            plastron = e;
            System.out.println("Le soldat " + getNom() + " s'équipe avec un plastron.");
        }
        if (e == Equipement.BOUCLIER && bouclier == null) {
            bouclier = e;
            System.out.println("Le soldat " + getNom() + " s'équipe avec un bouclier.");
        }
    }

    @Override
    public void recevoirCoup(int forceCoup) {
        int forceFinale = forceCoup;

        if (bouclier != null) {
            forceFinale -= bouclier.getProtection();
            System.out.println("Le bouclier absorbe " + bouclier.getProtection() + " du coup");
        }
        if (casque != null) {
            forceFinale -= casque.getProtection();
            System.out.println("Le casque absorbe " + casque.getProtection() + " du coup");
        }
        if (plastron != null) {
            forceFinale -= plastron.getProtection();
            System.out.println("Le plastron absorbe " + plastron.getProtection() + " du coup");
        }

        if (forceFinale < 0) forceFinale = 0;

        super.recevoirCoup(forceFinale);
    }

    @Override
    protected String donnerAuteur() {
        return "Le soldat " + getNom() + " [" + grade + "]";
    }

    @Override
    public void parler(String texte) {
        System.out.println(donnerAuteur() + " : « " + texte + " »");
    }
}
