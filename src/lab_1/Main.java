package lab_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {
            for (String arg : args) {
                int num = Integer.parseInt(arg);
                if (num < 0) {
                    throw new IllegalArgumentException("Parameter number must be positive number or zero.");
                }
                if (num >= 91) {
                    throw new IllegalArgumentException("Entered value is too large.");
                }
                LucasNumbersSequence seq1 = new LucasNumbersSequence();
                seq1.GenerateSequence(num);
                System.out.println(seq1.CheckSequence());
            }
        }
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("How many Lucas numbers do you want to check? ");
            int num = scanner.nextInt();
            if (num < 0) {
                throw new IllegalArgumentException("Parameter number must be positive number or zero. ");
            }
            if (num >= 91) {
                throw new IllegalArgumentException("Entered value is too large. ");
            }
            LucasNumbersSequence seq1 = new LucasNumbersSequence();
            seq1.GenerateSequence(num);
            System.out.println(seq1.CheckSequence());
        }
    }
}

