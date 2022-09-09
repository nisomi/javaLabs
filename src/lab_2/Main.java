package lab_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneList phones = addPhones();
        List<Phone> filtered = filteredByChoose(phones);
        for (Phone phone : filtered) {
            System.out.println(phone);
        }
    }

    public static PhoneList addPhones() {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Illya","Stasiuk","Viktorovich",917724,56,0));
        phones.add(new Phone("Maria","Slyusarchuk","Grigorivna",134392,345,0));
        phones.add(new Phone("Anna","Kasko","Yuriivna",101219,24,10));
        phones.add(new Phone("Matviy","Sabirov","Olegovych",123234,10,245));
        phones.add(new Phone("Ira","Kushynska","Vitalyivna",753234,345,0));
        phones.add(new Phone("Elizabeth","Tyshchuk","Tarasivna",101011,124,0));
        phones.add(new Phone("Pavlo","Zbural","Vitaliyovych",883123,12,34));
        return new PhoneList(phones);
    }

    public static List<Phone> filteredByChoose(PhoneList phones) {
        System.out.println("a: get information about those whose time of urban conversation exceeds preset");
        System.out.println("b: get information about subscribers who used long distance communication");
        System.out.println("c: information about subscribers whose account number is in the specified range");
        System.out.print("Choose: ");

        Scanner scanner = new Scanner(System.in);
        char choose = scanner.next().charAt(0);
        switch (choose) {
            case 'a':
                System.out.print("Urban conversation time: ");
                int urbanConversationTime = Integer.parseInt(scanner.next());
                return phones.conv_time_exceeds_preset(urbanConversationTime);
            case 'b':
                return phones.used_long_dist_comm();
            case 'c':
                System.out.print("Initial value: ");
                int init = Integer.parseInt(scanner.next());
                System.out.print("Final value: ");
                int fin = Integer.parseInt(scanner.next());
                return phones.acc_num_is_in_range(init,fin);
            default:
                throw new IllegalArgumentException("Invalid input choose.");
        }
    }
}
