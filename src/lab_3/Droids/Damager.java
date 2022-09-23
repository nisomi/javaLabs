package lab_3.Droids;

public class Damager extends BasicDroid {
    public static final int HP = 6000;
    public static final int DAMAGE = 1000;

    public Damager(String name) {
        super(name,HP,DAMAGE);
    }

    public String getType(){
        return "damager";
    }
}
