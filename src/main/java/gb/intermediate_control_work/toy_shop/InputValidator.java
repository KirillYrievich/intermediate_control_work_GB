package gb.java.intermediate_control_work.toy_shop;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private Set<Integer> idSet;

    public InputValidator() {
        idSet = new HashSet<>();
    }

    public boolean validateId(String input) {
        if (input.isEmpty()) {
            System.out.println("Ошибка: id не может быть пустым.");
            return false;
        }

        try {
            int id = Integer.parseInt(input);
            if (id <= 0) {
                System.out.println("Ошибка: id должен быть строго больше нуля.");
                return false;
            }

            if (idSet.contains(id)) {
                System.out.println("Ошибка: id должен быть уникальным.");
                return false;
            }

            idSet.add(id);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неправильный формат id.");
            return false;
        }

        return true;
    }

    public boolean validateName(String input) {
        if (input.isEmpty()) {
            System.out.println("Ошибка: название не может быть пустым.");
            return false;
        }

        return true;
    }

    public boolean validateFrequency(String input) {
        if (input.isEmpty()) {
            System.out.println("Ошибка: вес не может быть пустым.");
            return false;
        }

        try {
            int frequency = Integer.parseInt(input);
            if (frequency < 1 || frequency > 100) {
                System.out.println("Ошибка: вес должен быть в диапазоне от 1 до 100.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неправильный формат веса.");
            return false;
        }

        return true;
    }
    public boolean validateCount(String input) {
        if (input.isEmpty()) {
            System.out.println("Ошибка: количество игрушек не может быть пустым.");
            return false;
        }

        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                System.out.println("Ошибка: количество игрушек должно быть строго больше нуля.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неправильный формат количества игрушек.");
            return false;
        }

        return true;
    }
}
