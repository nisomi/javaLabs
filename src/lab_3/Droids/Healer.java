package lab_3.Droids;

import lab_3.Battles.*;

import static lab_3.Interface.ColorsAndStrings.*;

public class Healer extends BasicDroid{
    public static final int HP = 9000;
    public static final int DAMAGE = 500;

    public Healer(String name) {
        super(name,HP,DAMAGE);
    }

    public void heal(Fight battle) {
        int healHp = this.hpCurrent / 3;
        int realHealHp = 0;

        if ((battle instanceof Duel) && (this.hpCurrent != hpMax)) {
            this.hpCurrent += healHp;
            if (hpCurrent > HP) {
                realHealHp = healHp - hpCurrent + HP;
                hpCurrent = HP;
            }
            System.out.println(TABS+ANSI_GREEN+name + " heal itself with " + realHealHp + " HP"+ANSI_RESET);
        }

        if (battle instanceof TeamBattle) {
            int droidsNum = ((TeamBattle) battle).getAttackers().size();
            int HealHpPerDroid = healHp / droidsNum;
            for (BasicDroid droid:((TeamBattle) battle).getAttackers()) {
                realHealHp = HealHpPerDroid;
                droid.hpCurrent += HealHpPerDroid;
                if (droid.hpCurrent > droid.hpMax) {
                    realHealHp = HealHpPerDroid - droid.hpCurrent + droid.hpMax;
                    droid.hpCurrent = droid.hpMax;
                }
                System.out.println(TABS+ANSI_GREEN+this.name + " heal " + droid.name + " with " + realHealHp + " HP "+ANSI_RESET);
            }
        }
    }

}
