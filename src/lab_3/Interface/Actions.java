package lab_3.Interface;

import static lab_3.Interface.ColorsAndStrings.*;
import static lab_3.Interface.Tables.*;

import lab_3.Battles.*;
import lab_3.Droids.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Actions {
    public final static String FilePath = "E:\\2 курс\\1 сем\\ПП\\DroidBattle.txt";

    public static void createDroid(List<BasicDroid> listOfDroids) {
        int idDroid;
        String name;
        System.out.print(TABS+ANSI_GREEN+"please choose a droid to create: "+ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        idDroid = scanner.nextInt();
        switch (idDroid) {
            case 1: {
                scanner.nextLine();
                System.out.print(TABS+ANSI_GREEN+"enter the name of your killer: "+ANSI_RESET);
                name = scanner.nextLine();
                listOfDroids.add(new Killer(name));
                break;
            }
            case 2: {
                scanner.nextLine();
                System.out.print(TABS+ANSI_GREEN+"enter the name of your healer: "+ANSI_RESET);
                name = scanner.nextLine();
                listOfDroids.add(new Healer(name));
                break;
            }
            case 3: {
                scanner.nextLine();
                System.out.print(TABS+ANSI_GREEN+"enter the name of your shield: "+ANSI_RESET);
                name = scanner.nextLine();
                listOfDroids.add(new Shield(name));
                break;
            }
            case 4: {
                scanner.nextLine();
                System.out.print(TABS+ANSI_GREEN+"enter the name of your damager: "+ANSI_RESET);
                name = scanner.nextLine();
                listOfDroids.add(new Damager(name));
                break;
            }
            default: {
                scanner.nextLine();
                System.out.println(ANSI_BLUE + SHORT_TABS + "sorry, there are no droids with that type, please try again (^‿~)"+ANSI_RESET);
                break;
            }
        }
    }

    public static void showDroids(List<BasicDroid> listOfDroids) {
        if (listOfDroids.isEmpty()) {
            System.out.println(TABS+ANSI_RED+"you haven't created any droid yet  ╮(. ❛ ᴗ ❛.)╭"+ANSI_RESET);
            return;
        }
        printDroidsHeader();
        for (int i = 0; i < listOfDroids.size(); i++) {
            System.out.printf(TABS+"\t %3d    %-11s    ", (i + 1), listOfDroids.get(i).getName());
            if (listOfDroids.get(i) instanceof Killer) {
                System.out.println("killer");
            }
            else if (listOfDroids.get(i) instanceof Healer) {
                System.out.println("healer");
            }
            else if (listOfDroids.get(i) instanceof Shield) {
                System.out.println("shield");
            }
            else if (listOfDroids.get(i) instanceof Damager) {
                System.out.println("damager");
            }
        }
    }

    public static Duel startDuel(List<BasicDroid> listOfDroids) {
        BasicDroid firstDroid, secondDroid;
        showDroids(listOfDroids);
        System.out.println(TABS+ANSI_YELLOW+"now let's choose the droids for the duel (ㅅ´◡`)"+ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        int idFirstDroid,idSecondDroid;
        while (true) {
            System.out.print(TABS+ANSI_GREEN+"number of the first droid: "+ANSI_RESET);
            idFirstDroid = scanner.nextInt();
            if (ifDroidExist(listOfDroids,idFirstDroid)){
                firstDroid = listOfDroids.get(idFirstDroid - 1);
                break;
            }
        }
        while (true) {
            showDroids(listOfDroids);
            System.out.print(TABS+ANSI_GREEN+"number of the second droid: "+ANSI_RESET);
            idSecondDroid = scanner.nextInt();
            if (!ifDroidExist(listOfDroids,idSecondDroid)){
                continue;
            }
            else if (firstDroid instanceof Healer && listOfDroids.get(idSecondDroid - 1) instanceof Healer ) {
                System.out.println(SHORT_TABS+ANSI_RED+"you can't choose two healers for a duel, because it will be an endless battle, you know (´>_●)メ(●_<)"+ANSI_RESET);
                allDroidsHealers(listOfDroids);
            }
            else if (idFirstDroid==idSecondDroid){
                System.out.println(TABS+ANSI_RED+"you already chose this droid, so please choose another one (￣－￣)"+ANSI_RESET);
            }
            else {
                secondDroid = listOfDroids.get(idSecondDroid - 1);
                break;
            }
        }
        infoDuel(firstDroid, secondDroid);
        return new Duel(firstDroid, secondDroid);
    }

    public static TeamBattle startTeamBattle(List<BasicDroid> listOfDroids) {
        List<BasicDroid> team1 = new ArrayList<>();
        List<BasicDroid> team2 = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            System.out.print(TABS+ANSI_GREEN+"enter number of droids in each team:"+ANSI_RESET);
            num = scanner.nextInt();
            if (num <= listOfDroids.size() / 2) {
                break;
            }
            System.out.println(TABS+ANSI_RED+"looks like you don`t have enough droids to this battle  ╮(. ❛ ᴗ ❛.)╭"+ANSI_RESET);
        }
        scanner.nextLine();

        String teamName1, teamName2;
        System.out.print(TABS+ANSI_GREEN+"what do you call the first team?: "+ANSI_RESET);
        teamName1 = scanner.nextLine();
        showDroids(listOfDroids);
        System.out.println(TABS+ANSI_YELLOW+"now let's choose the droids for the first team - " + teamName1 + " (ㅅ´◡`)"+ANSI_RESET);
        int idDroid;
        int i = 1;
        int healers=0;
        while (true) {
            System.out.print(TABS+ANSI_GREEN+"code of droid " + i + ": "+ANSI_RESET);
            idDroid = scanner.nextInt();
            if (!ifDroidExist(listOfDroids,idDroid)){
                continue;
            }
            else if (team1.contains(listOfDroids.get(idDroid - 1))) {
                System.out.println(TABS+ANSI_RED+"you already added this droid, so please choose another one (￣－￣)"+ANSI_RESET);
            }
            else {
                if ((listOfDroids.get(idDroid-1) instanceof Healer) && (healers==1)){
                    System.out.println(TABS+ANSI_RED+"sorry, you can't take more than one healer in the team, choose someone else  ╮(. ❛ ᴗ ❛.)╭"+ANSI_RESET);
                    allDroidsHealers(listOfDroids);
                    showDroids(listOfDroids);
                }
                else {
                    team1.add(listOfDroids.get(idDroid - 1));
                    i++;
                    if (i > num) {
                        break;
                    }
                    if (listOfDroids.get(idDroid-1) instanceof Healer)
                        healers++;
                }
            }
        }
        scanner.nextLine();
        System.out.print(TABS+ANSI_GREEN+"what do you call the second team?: "+ANSI_RESET);
        teamName2 = scanner.nextLine();
        showDroids(listOfDroids);
        System.out.println(TABS+ANSI_YELLOW+"now let's choose the droids for the second team - " + teamName2 + " (ㅅ´◡`)"+ANSI_RESET);
        i = 1;
        healers=0;
        while (true) {
            System.out.print(TABS+ANSI_GREEN+"code of droid " + i + ": "+ANSI_RESET);
            idDroid = scanner.nextInt();
            if (!ifDroidExist(listOfDroids,idDroid)){
                continue;
            }
            else if (team2.contains(listOfDroids.get(idDroid - 1)) || team1.contains(listOfDroids.get(idDroid - 1))) {
                System.out.println(TABS+ANSI_RED+"you already added this droid, so please choose another one (￣－￣)"+ANSI_RESET);
            }
            else {
                if ((listOfDroids.get(idDroid-1) instanceof Healer) && (((team1.size() == 1) && (team1.get(0) instanceof Healer))))  {
                    System.out.println(ANSI_RED + "\t\t\t\t\tyou can't choose only two healers for a team battle, because it will be an endless battle (´>_●)メ(●_<)" + ANSI_RESET);
                    allDroidsHealersTeam(listOfDroids,team1);
                    showDroids(listOfDroids);
                    }
                else if ((listOfDroids.get(idDroid-1) instanceof Healer) && (healers==1))  {
                    System.out.println(TABS + ANSI_RED + "sorry, you can't take more than one healer in the team, choose someone else   ╮(. ❛ ᴗ ❛.)╭" + ANSI_RESET);
                    allDroidsHealersTeam(listOfDroids,team1);
                    showDroids(listOfDroids);
                }
                else {
                    team2.add(listOfDroids.get(idDroid - 1));
                    i++;
                    if (i > num) {
                        break;
                    }
                    if (listOfDroids.get(idDroid-1) instanceof Healer)
                        healers++;
                }
            }
        }
        infoTeamBattle(team1,team2,teamName1,teamName2);
        return new TeamBattle(teamName1, teamName2, team1, team2);
    }

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

    public static void restoreHP(List<BasicDroid> listOfDroids) {
        for (BasicDroid droid : listOfDroids) {
            if (droid.getHpCurrent() != droid.getHpMax()) {
                droid.setHpCurrent(droid.getHpMax());
            }
        }
    }

    public static boolean ifDroidExist(List<BasicDroid> listOfDroids, int idDroid) {
        if ((idDroid > listOfDroids.size()) || ((idDroid < 0))) {
            System.out.println(TABS + ANSI_RED + "looks like i can't find that droid, try again (￣－￣)" + ANSI_RESET);
            return false;
        }
        return true;
    }
    public static void allDroidsHealers(List<BasicDroid> listOfDroids){
        int healers = 0;
        for (BasicDroid droid:listOfDroids){
            if (droid instanceof Healer)
                healers++;
        }
        if (listOfDroids.size()==healers){
            System.out.println(SHORT_TABS+ANSI_RED+"looks like you have no other option, so let's create another droid (ㅅ´◡`)"+ANSI_RESET);
            Tables.showDroidMenu();
            createDroid(listOfDroids);
        }
    }

    public static void allDroidsHealersTeam(List<BasicDroid> listOfDroids, List<BasicDroid> listOfDroidsTeam){
        int allHealers = 0;
        for (BasicDroid droid:listOfDroids){
            if (droid instanceof Healer)
                allHealers++;
        }
        int allHealersTeam = 0;
        for (BasicDroid droid:listOfDroidsTeam){
            if (droid instanceof Healer)
                allHealersTeam++;
        }
        if (listOfDroids.size()==allHealers-allHealersTeam+listOfDroidsTeam.size()){
            System.out.println(SHORT_TABS+ANSI_RED+"looks like you have no other option, so let's create another droid (ㅅ´◡`)"+ANSI_RESET);
            Tables.showDroidMenu();
            createDroid(listOfDroids);
        }
    }

    public static void infoDuel(BasicDroid droid1, BasicDroid droid2){
        System.out.println(LINE);
        System.out.println(TABS + ANSI_BLUE + "\t\t\t\t" + droid1 + " vs " +droid2 +ANSI_RESET);
    }

    public static void infoTeamBattle(List<BasicDroid> team1, List<BasicDroid> team2, String teamName1, String teamName2){
        System.out.println(LINE);
        System.out.print(TABS + ANSI_BLUE +  teamName1 + " : ");
        for (BasicDroid droid:team1){
            System.out.print(droid + " ");
        }
        System.out.print(TABS + ANSI_CYAN + teamName2 + " : ");
        for (BasicDroid droid:team2){
            System.out.print(droid + " ");
        }
        System.out.println(ANSI_RESET);
    }
}
