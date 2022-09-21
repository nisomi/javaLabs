package lab_3;

import lab_3.Interface.DroidBattle;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        DroidBattle game = new DroidBattle();
        game.start();
    }
}