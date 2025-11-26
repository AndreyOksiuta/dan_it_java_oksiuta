package java_core_hw_9;

import java.util.Scanner;

public class AplicationController {
    FamilyController familyController = new FamilyController(new FamilyService(new CollectionFamilyDao()));

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose option");
            printOption();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                familyController.displayAllFamilies();
                return;
            }
            if (option.equals("2")) {
                System.out.println("Input number for filter");
                int number = scanner.nextInt();
                familyController.displayAllFamilies(familyController.getFamiliesBiggerThan(number));
                return;
            }
            if (option.equals("3")) {
                System.out.println("Input number for filter");
                int number = scanner.nextInt();
                familyController.displayAllFamilies(familyController.getFamiliesLessThan(number));
                return;
            }
            if (option.equals("4")) {

            }
            if (option.equals("5")) {

            }
            if (option.equals("6")) {

            }
            if (option.equals("7")) {

            }
            if (option.equals("8")) {

            }
        }

    }


    private void printOption() {
        String option = "1-display all families\n" +
                "2-display families biggest number\n" +
                "3-display families smallest number\n" +
                "4-display families where size is number\n" +
                "5-create new family\n" +
                "6-delete family by index\n" +
                "7-update family\n" +
                "8-delete all children older year";
        System.out.println(option);
    }
    public static void main(String[] args) {
        new AplicationController().start();
    }
}
