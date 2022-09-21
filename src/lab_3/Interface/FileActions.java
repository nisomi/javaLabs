package lab_3.Interface;

import lab_3.Battles.Duel;
import lab_3.Battles.TeamBattle;
import lab_3.Droids.BasicDroid;

import java.io.*;
import java.util.List;

import static lab_3.Interface.Actions.startDuel;
import static lab_3.Interface.Actions.startTeamBattle;
import static lab_3.Interface.ColorsAndStrings.*;
import static lab_3.Interface.ColorsAndStrings.ANSI_RESET;

public class FileActions {
    public final static String FilePath = "E:\\2 курс\\1 сем\\ПП\\DroidBattle.txt";

    public static void saveDuelToFile(List<BasicDroid> listOfDroids) throws IOException {
        Duel battle = startDuel(listOfDroids);
        PrintWriter out = new PrintWriter(new FileWriter(FilePath));
        PrintStream console = System.out;
        console.flush();
        FileOutputStream fileOutputStream = new FileOutputStream(FilePath);
        PrintStream fileOut = new PrintStream(fileOutputStream, false);
        System.setOut(fileOut);
        System.out.println(TABS + ANSI_BLUE + "\t\tthe duel starts   (⁰▿⁰)◜-ι═══════>" + ANSI_RESET);
        System.out.println(TABS + ANSI_GREEN + "\t\t\t\t" + battle.droidVsDroid() + " won! ヽ(≧▿≦)ノ" + ANSI_RESET);
        fileOutputStream.flush();
        fileOut.flush();
        out.flush();
        out.close();
        System.setOut(console);
        System.out.println(TABS+ANSI_GREEN+"successfully saved to a file ( o˘◡˘o)"+ANSI_RESET);
    }

    public static void saveTeamBattleToFile(List<BasicDroid> listOfDroids) throws IOException {
        TeamBattle teamBattle = startTeamBattle(listOfDroids);
        PrintStream consoleStream = System.out;
        FileOutputStream fileOutputStream = new FileOutputStream(FilePath);
        PrintStream stream = new PrintStream(fileOutputStream);
        System.setOut(stream);
        System.out.println(TABS + ANSI_BLUE + "\tthe team-battle starts Ｏ(｀_´)乂(｀_´ )Ｏ" + ANSI_RESET);
        System.out.println(TABS + ANSI_BLUE + "\t\t\t\t" + teamBattle.teamVsTeam() + " won! ヽ(≧▿≦)ノ" + ANSI_RESET);
        System.setOut(consoleStream);
        fileOutputStream.close();
        stream.close();
        System.out.println(TABS+ANSI_GREEN+"successfully saved to a file ( o˘◡˘o)"+ANSI_RESET);
    }

    public static void outputLastBattleFromFile() throws IOException {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(FilePath)));
        while (fileReader.ready()) {
            System.out.println(fileReader.readLine());
        }
        fileReader.close();
    }
}
