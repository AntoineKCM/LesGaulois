package batailles;

public class BatailleGaulois extends Bataille {

    @Override
    public void decrireContexte() {
        System.out.println("Un groupe de gaulois rencontre un bataillon de soldats romains.");
    }

    @Override
    public void choisirCombattants() {
        System.out.println("Les combattants sont Asterix, Obelix et les soldats romains.");
    }

    @Override
    public void preparerCombat() {
        System.out.println("Les combattants se placent et se préparent au combat.");
    }

    @Override
    public void decrireCombat() {
        System.out.println("Asterix frappe avec sa potion magique, les soldats résistent avec leurs boucliers.");
    }

    @Override
    public void donnerResultat() {
        System.out.println("Les gaulois remportent la bataille !");
    }
}