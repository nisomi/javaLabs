package lab_3.Battles;

import lab_3.Droids.*;

import java.util.List;
import java.util.Random;

import static lab_3.Interface.ColorsAndStrings.*;
import static lab_3.Interface.ColorsAndStrings.ANSI_RESET;

public class TeamBattle extends Fight {
    private String attackName;
    private List<BasicDroid> attackers;
    private String defendName;
    private List<BasicDroid> defenders;

    public TeamBattle(String teamName1, String teamName2, List<BasicDroid> team1, List<BasicDroid> team2) {
        Random random = new Random();
        if (random.nextBoolean()) {
            this.attackers = team1;
            attackName = teamName1;
            this.defenders = team2;
            defendName = teamName2;
        } else {
            this.attackers = team2;
            attackName = teamName2;
            this.defenders = team1;
            defendName = teamName1;
        }
    }

    public String teamVsTeam() {
        while ((attackers.size() != 0) && (defenders.size()!=0)) {
            fighting();
            swap();
        }
        if (attackers.size()==0){
            return defendName;
        }
        else {
            return attackName;
        }
    }

    private void fighting() {
        Random random = new Random();
        fight(attackers.get(random.nextInt(attackers.size())), defenders.get(random.nextInt(defenders.size())));
        defenders.removeIf(droid -> !droid.isAlive());
    }

    private void swap() {
        List<BasicDroid> t = attackers;
        attackers = defenders;
        defenders = t;
        String tStr = attackName;
        attackName = defendName;
        defendName = tStr;
    }

    public List<BasicDroid> getAttackers() {
        return attackers;
    }

    public List<BasicDroid> getDefenders() {
        return defenders;
    }

    public void getInfo(){
        System.out.println(LINE);
        System.out.print(TABS + ANSI_BLUE +  attackName + " : ");
        for (BasicDroid droid:attackers){
            System.out.print(droid + " ");
        }
        System.out.print(TABS + ANSI_CYAN + defendName + " : ");
        for (BasicDroid droid:defenders){
            System.out.print(droid + " ");
        }
        System.out.println(ANSI_RESET);
    }
}
