package gb.java.intermediate_control_work.toy_shop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        InputValidator validator = new InputValidator();

        Scanner scanner = new Scanner(System.in);
        int count;
        while (true) {
            System.out.println("Введите количество игрушек для добавления:");
            String input = scanner.nextLine();
            if (validator.validateCount(input)) {
                count = Integer.parseInt(input);
                break;
            }
        }

        for (int i = 0; i < count; i++) {
            String id;
            while (true) {
                System.out.println("Введите id игрушки (целое число):");
                String input = scanner.nextLine();
                if (validator.validateId(input)) {
                    id = input;
                    break;
                }
            }

            System.out.println("Введите название игрушки:");
            String name = scanner.nextLine();
            while (!validator.validateName(name)) {
                System.out.println("Введите название игрушки:");
                name = scanner.nextLine();
            }

            System.out.println("Введите вес игрушки (от 1 до 100):");
            String frequency = scanner.nextLine();
            while (!validator.validateFrequency(frequency)) {
                System.out.println("Введите вес игрушки (от 1 до 100):");
                frequency = scanner.nextLine();
            }

            lottery.addToy(id, name, frequency);
        }

        lottery.displayToys();
        Toy winner = lottery.getWinner();
        System.out.println("Winner: " + winner.getName());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"))) {
            for (int i = 0; i < 10; i++) {
                Toy toy = lottery.drawWinner();
                if (toy != null) {
                    writer.write("Toy " + (i + 1) + ": " + toy.getName() + "\n");
                } else {
                    writer.write("Toy " + (i + 1) + ": Игрушек больше нет!\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
