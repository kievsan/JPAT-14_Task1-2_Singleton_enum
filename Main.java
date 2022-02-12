//package knhel7.jd14.jpat14.task12;

// Task12
// Домашнее задание к занятию 1.1.
// Порождающие шаблоны.
// Singleton (Одиночка).
// Задача 2. Логгер
// с помощью enum

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);
    static int intScan;

    public static void main(String[] args) {
        Logger logger = Logger.SINGLE_INSTANCE;
        logger.log("Launch the program!");

        while (true) {
            logger.log("Enter the input data for list!");
            System.out.println("\nОжидаю ввода размера списка: " +
                    "(для завершения введите 0)");
            String errMsg = "\tОшибка! Неидентифицируемый / некорректный ввод...";
            if (badInput(0, 0, errMsg)) continue;
            if (intScan == 0) break;
            int n = intScan;

            do {
                System.out.println("\nОжидаю верхнюю границу для значений (не меньше 0): ");
            } while (badInput(0, 0, errMsg));
            int m = intScan;

            List<Integer> arr = makeRandomList(n, m);
            printList(arr, "\nСписок из " + n + " случайных чисел от 0 до " + m);

            do {
                logger.log("Enter the input data for filtering!");
                System.out.println("\nОжидаю порог для фильтра (не меньше 0): ");
            } while (badInput(0, m, errMsg));
            int f = intScan;

            Filter filter = new Filter(f);
            List<Integer> filteredList = filter.filterOut(arr);
            printList(filteredList, "\nОтфильтрованный список (не вошли числа меньше " + f + ")");
        }
        logger.log("Completing the program!");
    }

    public static List<Integer> makeRandomList(int sizeOfList, int maxValue) {
        Logger logger = Logger.SINGLE_INSTANCE;
        logger.log("Create and fill the list...");

        List<Integer> randomList = new ArrayList<>(sizeOfList);
        Random random = new Random();

        for (int i = 0; i < sizeOfList; i++) {
            Integer naturalNumber = random.nextInt(maxValue);
            randomList.add(naturalNumber);
        }
        return randomList;
    }

    public static <T> void printList(List<T> list, String message) {
        Logger logger = Logger.SINGLE_INSTANCE;
        logger.log("Look at the list on the screen!");
        System.out.println(message + ":");
        for (T each : list) {
            System.out.print(each + ",  ");
        }
        System.out.println("\n");
    }

    public static boolean badInput(int min, int max, String err_msg) {
        try {
            intScan = SCANNER.nextInt();
        } catch (RuntimeException e) {
            System.out.println(err_msg.trim());
            SCANNER.nextLine();
            return true;
        }
        SCANNER.nextLine();
        if (intScan < min ||
                (intScan > max && max > min)) {
            System.out.println(err_msg.trim());
            return true;
        }
        return false;
    }

}
