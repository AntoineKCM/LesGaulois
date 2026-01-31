package batailles;

public abstract class Bataille {
    public abstract void decrireContexte();
    public abstract void choisirCombattants();
    public abstract void preparerCombat();
    public abstract void decrireCombat();
    public abstract void donnerResultat();

    public void raconter() {
        decrireContexte();
        choisirCombattants();
        preparerCombat();
        decrireCombat();
        donnerResultat();
    }
}