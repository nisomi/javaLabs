package lab_3.Droids;

import java.util.Random;

import static lab_3.Interface.ColorsAndStrings.*;

public class Killer extends BasicDroid{
    public static final double DAMAGE_BONUS = 1.5;
    public static final int HP = 5000;
    public static final int DAMAGE = 800;

    public Killer(String name) {
        super(name,HP,DAMAGE);
    }

    public String getType(){
        return "killer";
    }

    @Override
    public int attack(BasicDroid droid) {
        Random random = new Random();
        int damagePoints = 0;
        if(this.hpCurrent > 0.5 * HP) {
            damagePoints = random.nextInt(20) + (int) (this.damage * DAMAGE_BONUS) - 20;
        }
        else {
            damagePoints = random.nextInt(20) + this.damage - 20;
        }
        int actualDamage = droid.receiveDamage(damagePoints);
        System.out.println(TABS+ANSI_YELLOW + droid + " got hit by " + this +" with " + damagePoints + " and damaged with " + actualDamage+" HP "+ANSI_RESET );
        if (droid.hpCurrent <= 0) {
            droid.hpCurrent = 0;
            System.out.println(TABS+ANSI_RED+"\t\t\t\t"+droid.name + " failed (✖╭╮✖)");
        }
        return damage;
    }

}
