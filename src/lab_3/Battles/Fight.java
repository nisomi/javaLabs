package lab_3.Battles;

import lab_3.Droids.*;


public abstract class Fight {
    public void fight(BasicDroid attacker, BasicDroid defender) {
        if (attacker.attack(defender) != 0) {
            if (attacker instanceof Healer) {
                ((Healer) attacker).heal(this);
            }
        }
    }

    abstract public void getInfo();
}
