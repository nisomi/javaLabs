package lab_3.Interface;

import lab_3.Battles.Duel;
import lab_3.Battles.TeamBattle;
import lab_3.Droids.BasicDroid;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static lab_3.Interface.Actions.*;
import static lab_3.Interface.ColorsAndStrings.*;

public class FileActions {
    public final static String FilePath = "E:\\2 курс\\1 сем\\ПП\\DroidBattle.txt";

    public static void saveDuelToFile(List<BasicDroid> listOfDroids) throws IOException {
        Duel battle = startDuel(listOfDroids);
        PrintStream console = System.out;
        PrintStream fileOut = new PrintStream(FilePath);
        System.setOut(fileOut);
        System.out.println(LINE);
        battle.getInfo();
        System.out.println(LINE);
        System.out.println(TABS + ANSI_BLUE + "\t\tthe duel starts   (⁰▿⁰)◜-ι═══════>" + ANSI_RESET);
        System.out.println(TABS + ANSI_GREEN + "\t\t\t\t" + battle.droidVsDroid() + " won! ヽ(≧▿≦)ノ" + ANSI_RESET);
        System.out.println(LINE);
        fileOut.flush();
        fileOut.close();
        System.setOut(console);
        System.out.println(TABS+ANSI_GREEN+"successfully saved to a file ( o˘◡˘o)"+ANSI_RESET);
    }

    public static void saveTeamBattleToFile(List<BasicDroid> listOfDroids) throws IOException {
        TeamBattle teamBattle = startTeamBattle(listOfDroids);
        PrintStream console = System.out;
        PrintStream fileOut = new PrintStream(FilePath);
        System.setOut(fileOut);
        System.out.println(LINE);
        teamBattle.getInfo();
        System.out.println(LINE);
        System.out.println(TABS + ANSI_BLUE + "\tthe team-battle starts Ｏ(｀_´)乂(｀_´ )Ｏ" + ANSI_RESET);
        System.out.println(TABS + ANSI_BLUE + "\t\t\t\t" + teamBattle.teamVsTeam() + " won! ヽ(≧▿≦)ノ" + ANSI_RESET);
        System.out.println(LINE);
        fileOut.flush();
        fileOut.close();
        System.setOut(console);
        System.out.println(TABS+ANSI_GREEN+"successfully saved to a file ( o˘◡˘o)"+ANSI_RESET);
    }

    public static void outputLastBattleFromFile() throws IOException {
        File file = new File(FilePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
