package java_core_hw_2;

import java.util.Arrays;
import java.util.Scanner;

public class java_core_hw_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] scedule = new String[7][2];
        scedule[0][0] = "sunday";
        scedule[0][1] = "chiil";
        scedule[1][0] = "monday";
        scedule[1][1] = "Go to mall";
        scedule[2][0] = "tuesday";
        scedule[2][1] = "Go to gym";
        scedule[3][0] = "wednesday";
        scedule[3][1] = "Go to pool";
        scedule[4][0] = "thursday";
        scedule[4][1] = "go to courses; watch a film";
        scedule[5][0] = "friday";
        scedule[5][1] = "Go to bar";
        scedule[6][0] = "saturday";
        scedule[6][1] = "Go to parents";
        while (true) {
            System.out.println("Please, input the day of the week");
            String day = input.nextLine();
            String[] days = day.split(" ");
            switch (days[0].trim().toLowerCase()) {
                case "sunday":
                    System.out.println(scedule[0][1]);
                    break;
                case "monday":
                    System.out.println(scedule[1][1]);
                    break;
                case "tuesday":
                    System.out.println(scedule[2][1]);
                    break;
                case "wednesday":
                    System.out.println(scedule[3][1]);
                    break;
                case "thursday":
                    System.out.println(scedule[4][1]);
                    break;
                case "friday":
                    System.out.println(scedule[5][1]);
                    break;
                case "saturday":
                    System.out.println(scedule[6][1]);
                    break;
                case "exit":
                    return;
                case "change":
                    boolean findDay = false;
                    for (int i = 0; i < 7; i++) {
                        if (days[1].equalsIgnoreCase(scedule[i][0])) {
                            System.out.println("Please, input new tasks for " + scedule[i][0]);
                            String data = input.nextLine();
                            scedule[i][1] = data;
                            findDay = true;
                            break;
                        }
                    }
                    if (findDay == false) {
                        System.out.println("Sorry, I can't find day, please try again");
                    }
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again");
                    break;
            }
        }
    }
}
