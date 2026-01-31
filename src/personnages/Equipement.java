package personnages;

public enum Equipement {
    CASQUE(2),
    PLASTRON(3),
    BOUCLIER(3);

    private int protection;

    private Equipement(int protection) {
        this.protection = protection;
    }

    public int getProtection() {
        return protection;
    }
}
