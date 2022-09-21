package lab_3.Interface;
import lab_3.Battles.Duel;
import lab_3.Battles.TeamBattle;
import lab_3.Droids.BasicDroid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lab_3.Interface.Actions.*;
import static lab_3.Interface.ColorsAndStrings.*;
import static lab_3.Interface.FileActions.*;

public class DroidBattle {
    private static List<BasicDroid> listOfDroids;
    private static Scanner scanner = new Scanner(System.in);

    public DroidBattle() {
        listOfDroids = new ArrayList<>();
    }

    public static void start() throws IOException {

        System.out.println(ANSI_GREEN + "\n" + TABS + "\they, let's play a game  ( ＾◡＾)っ" + ANSI_RESET);
        int idAction;

        while (true) {

            Tables.showActionsMenu();
            System.out.print(ANSI_GREEN + "\n" + TABS + "choose the option you want to perform: " + ANSI_RESET);
            idAction = scanner.nextInt();

            switch (idAction) {
                case 1: {
                    Tables.showDroidMenu();
                    createDroid(listOfDroids);
                    break;
                }
                case 2: {
                    showDroids(listOfDroids);
                    break;
                }
                case 3: {
                    if (listOfDroids.size()>=2) {
                        Duel battle = startDuel(listOfDroids);
                        System.out.println(LINE);
                        System.out.println(TABS + ANSI_BLUE + "\t\tthe duel starts   (⁰▿⁰)◜-ι═══════>" + ANSI_RESET);
                        System.out.println(TABS + ANSI_GREEN + "\t\t\t\t" + battle.droidVsDroid() + " won! ヽ(≧▿≦)ノ" + ANSI_RESET);
                        System.out.println(LINE);
                        restoreHP(listOfDroids);
                    }
                    else
                        System.out.println(TABS+ANSI_RED+"looks like you don`t have enough droids to this battle ヽ(シ)ノ"+ANSI_RESET);
                    break;
                }
                case 4: {
                    if (listOfDroids.size()>=2) {
                        TeamBattle teamBattle = startTeamBattle(listOfDroids);
                        System.out.println(LINE);
                        System.out.println(TABS + ANSI_BLUE + "\tthe team-battle starts Ｏ(｀_´)乂(｀_´ )Ｏ" + ANSI_RESET);
                        System.out.println(TABS + ANSI_BLUE + "\t\t\t\t" + teamBattle.teamVsTeam() + " won! ヽ(≧▿≦)ノ" + ANSI_RESET);
                        System.out.println(LINE);
                        restoreHP(listOfDroids);
                    }
                    else
                        System.out.println(TABS+ANSI_RED+"looks like you don`t have enough droids to this battle ヽ(シ)ノ"+ANSI_RESET);
                    break;
                }
                case 5: {
                    System.out.print(TABS+ANSI_GREEN+"what do want to save, duel or team battle? (1/2)   ");
                    if (scanner.hasNext("1")) {
                        saveDuelToFile(listOfDroids);
                    } else if (scanner.hasNext("2")) {
                        saveTeamBattleToFile(listOfDroids);
                    } else {
                        System.out.println(TABS+ANSI_RED+"\t\t\t\t*confused* (☉_☉)"+ANSI_RESET);
                    }
                    scanner.nextLine();
                    scanner.nextLine();
                    restoreHP(listOfDroids);
                    break;
                }
                case 6: {
                    outputLastBattleFromFile();
                    break;
                }
                case 7: {
                    System.out.println(TABS+ANSI_YELLOW+"\t\tthank`s for playing (⌒‿⌒)ﾉ"+ANSI_RESET);
                    return;
                }
                default:
                    System.out.println(TABS+ANSI_RED+"nice try, but i don't understand  *skips* ¯\\_(ツ )_/¯"+ANSI_RESET);
            }
        }
    }
}

