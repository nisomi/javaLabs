package lab_3.Droids;

public class Shield extends BasicDroid{
    public static final int SHIELD = 2;
    public static final int HP = 8000;
    public static final int DAMAGE = 600;

    public Shield(String name) {
        super(name,HP,DAMAGE);
    }

    @Override
    public int receiveDamage(int hit){
        this.hpCurrent -= hit /SHIELD;
        return hit;
    }
}
