package lab_3.Battles;

import lab_3.Droids.BasicDroid;

import java.util.Random;

import static lab_3.Interface.ColorsAndStrings.*;

public class Duel extends Fight{
    private BasicDroid attacker;
    private BasicDroid defender;

    public Duel(BasicDroid droid1, BasicDroid droid2) {
        Random random = new Random();
        if (random.nextBoolean()) {
            this.attacker = droid1;
            this.defender = droid2;
        } else {
            this.attacker = droid2;
            this.defender = droid1;
        }
    }

    public String droidVsDroid() {
        while (attacker.isAlive()) {
            fight(attacker, defender);
            swap();
        }
        return defender.getName();
    }

    private void swap() {
        BasicDroid tmp = attacker;
        attacker = defender;
        defender = tmp;
    }

}
