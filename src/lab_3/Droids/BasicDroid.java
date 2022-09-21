package lab_3.Droids;

import java.util.Random;

import static lab_3.Interface.ColorsAndStrings.*;

public abstract class BasicDroid {
    protected String name;
    protected int hpCurrent;
    protected int hpMax;
    protected int damage;

    public BasicDroid(String name, int hp, int damage) {
        this.name = name;
        this.hpCurrent = hp;
        this.hpMax = hp;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return " " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHpCurrent() {
        return hpCurrent;
    }

    public void setHpCurrent(int hpCurrent) {
        this.hpCurrent = hpCurrent;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public boolean isAlive() {
        return hpCurrent >0;
    }

    public int attack(BasicDroid droid) {
        Random random = new Random();
        int damagePoints = 0;
        damagePoints = random.nextInt(20) + this.damage - 20;
        int actualDamage = droid.receiveDamage(damagePoints);
        System.out.println(TABS+ANSI_YELLOW + droid + " got hit by " + this + " with " + damagePoints + " and damaged with " + actualDamage+" HP "+ANSI_RESET );
        if (droid.hpCurrent <= 0) {
            droid.hpCurrent = 0;
            System.out.println(TABS+ANSI_RED+"\t\t\t\t"+droid.name + " failed (✖╭╮✖)");
        }
        return damage;
    }

    public int receiveDamage(int hit) {
        this.hpCurrent -= hit;
        return hit;
    }
}
