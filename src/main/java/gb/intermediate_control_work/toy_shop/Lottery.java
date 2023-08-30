package gb.java.intermediate_control_work.toy_shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {
    private List<Toy> toys;

    public Lottery() {
        toys = new ArrayList<>();
    }

    public void addToy(String id, String name, String frequency) {
        Toy toy = new Toy(id, name, frequency);
        toys.add(toy);
    }

    public Toy drawWinner() {
        int totalFrequency = 0;
        for (Toy toy : toys) {
            totalFrequency += toy.getFrequency();
        }

        Random random = new Random();
        int randomNumber = random.nextInt(totalFrequency) + 1;

        int cumulativeFrequency = 0;
        for (Toy toy : toys) {
            cumulativeFrequency += toy.getFrequency();
            if (randomNumber <= cumulativeFrequency) {
                return toy;
            }
        }

        return null;
    }

    public void displayToys() {
        System.out.println("Available Toys:");
        for (Toy toy : toys) {
            System.out.println("Toy: " + toy.getName() + ", Frequency: " + toy.getFrequency());
        }
    }

    public Toy getWinner() {
        return drawWinner();
    }
}
