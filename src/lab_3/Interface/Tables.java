package lab_3.Interface;
import static lab_3.Interface.ColorsAndStrings.*;
import lab_3.Droids.*;

public class Tables {
    public static void showActionsMenu(){
        System.out.println(TABS+"┎─────┰─────────────────────────────────┒");
        System.out.println(TABS+"┃  №  ┃           Actions               ┃");
        System.out.println(TABS+"┠─────╂─────────────────────────────────┨");
        System.out.println(TABS+"┃  1  ┃  create droid                   ┃");
        System.out.println(TABS+"┃  2  ┃  show list of created droids    ┃");
        System.out.println(TABS+"┃  3  ┃  start a duel                   ┃");
        System.out.println(TABS+"┃  4  ┃  start a team battle            ┃");
        System.out.println(TABS+"┃  5  ┃  save the battle to a file      ┃");
        System.out.println(TABS+"┃  6  ┃  play last battle from file     ┃");
        System.out.println(TABS+"┃  7  ┃  quit the game                  ┃");
        System.out.println(TABS+"┖─────┸─────────────────────────────────┚");
    }

    public static void showDroidMenu(){
        System.out.println("\t\t\t\t\t┎─────┰───────────┰───────────────────────────┰──────────────────────────────────────────────────────────────────┒");
        System.out.println("\t\t\t\t\t┃  №  ┃   Droid   ┃      Characteristics      ┃                           Skill                                  ┃");
        System.out.println("\t\t\t\t\t┠─────╂───────────╂───────────────────────────╂──────────────────────────────────────────────────────────────────┨");
        System.out.printf( "\t\t\t\t\t┃  1  ┃  Killer   ┃  HP=%d    damage=%d    ┃ Can deal more damage when above %%50 HP                           ┃\n", Killer.HP, Killer.DAMAGE);
        System.out.printf( "\t\t\t\t\t┃  2  ┃  Healer   ┃  HP=%d    damage=%d    ┃ Can restore HP either to himself or to the team                  ┃\n", Healer.HP,Healer.DAMAGE);
        System.out.println("\t\t\t\t\t┃     ┃           ┃                           ┃ by a total amount equal to third of his current HP               ┃");
        System.out.printf( "\t\t\t\t\t┃  3  ┃  Shield   ┃  HP=%d    damage=%d    ┃ Takes damage 1.5 times less thanks to his shield                 ┃\n", Shield.HP,Shield.DAMAGE);
        System.out.printf( "\t\t\t\t\t┃  4  ┃  Damager  ┃  HP=%d    damage=%d   ┃ Just does a lot of damage                                        ┃\n", Damager.HP,Damager.DAMAGE);
        System.out.println("\t\t\t\t\t┖─────┸───────────┸───────────────────────────┸──────────────────────────────────────────────────────────────────┚");
    }

    public static void printDroidsHeader(){
        System.out.println(TABS+"\t┎─────┰─────────────┰─────────────┒");
        System.out.println(TABS+"\t┃  №  ┃    Name     ┃    Class    ┃");
        System.out.println(TABS+"\t┖─────┸─────────────┸─────────────┚");
    }
}
