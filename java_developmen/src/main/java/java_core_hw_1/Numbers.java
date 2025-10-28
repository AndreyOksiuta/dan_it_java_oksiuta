package java_core_hw_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int[] arrayForInputNumber = new int[100];
        int pozitionToSaveNumber = 0;
        System.out.println("Game starts! Input your name");
        String name = scanner.nextLine();
        int randon = random.nextInt(101);
        System.out.println("Randon number-" + randon);
        System.out.println(" Let the game begin input number from 0 to 100");

        while (true) {
            String numberFromScaner = scanner.next();
            if (!checkNumber(numberFromScaner)) {
                continue;
            }
            int number = Integer.parseInt(numberFromScaner);
            if (number < randon) {
                System.out.println("Your number is too small. Please, try again.");
                arrayForInputNumber[pozitionToSaveNumber] = number;
                pozitionToSaveNumber++;
            }
            if (number > randon) {
                System.out.println("Your number is too big. Please, try again");
                arrayForInputNumber[pozitionToSaveNumber] = number;
                pozitionToSaveNumber++;
            }
            if (number == randon) {
                arrayForInputNumber[pozitionToSaveNumber] = randon;
                System.out.println("Congratulation " + name + " " + randon + " its correct number");
                int[] inputNumberBeforeFindCorrctNumber = new int[pozitionToSaveNumber];
                System.arraycopy(arrayForInputNumber, 0, inputNumberBeforeFindCorrctNumber, 0, pozitionToSaveNumber);
                Arrays.sort(inputNumberBeforeFindCorrctNumber);
                System.out.println("All you input number" + Arrays.toString(inputNumberBeforeFindCorrctNumber));
                break;
            }
        }
    }
    private static boolean checkNumber(String numberFromScaner) {
        char[] checkDataForCorrectInput = numberFromScaner.toCharArray();
        for (int j = 0; j < checkDataForCorrectInput.length; j++) {
            if (checkDataForCorrectInput[j] < 48 || checkDataForCorrectInput[j] > 57) {
                System.out.println("Wrong input");
                return false;
            }
        }
        return true;
    }
}
