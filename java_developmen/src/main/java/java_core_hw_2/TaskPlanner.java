package java_core_hw_2;

import java.util.Scanner;

public class TaskPlanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] schedule = new String[7][2];
        newSchedule(schedule);
        while (true) {
            System.out.println("Please, input the day of the week");
            String dayOfWeek = input.nextLine();
            String[] days = dayOfWeek.split(" ");
            switch (days[0].trim().toLowerCase()) {
                case "sunday":
                    System.out.println(schedule[0][1]);
                    break;
                case "monday":
                    System.out.println(schedule[1][1]);
                    break;
                case "tuesday":
                    System.out.println(schedule[2][1]);
                    break;
                case "wednesday":
                    System.out.println(schedule[3][1]);
                    break;
                case "thursday":
                    System.out.println(schedule[4][1]);
                    break;
                case "friday":
                    System.out.println(schedule[5][1]);
                    break;
                case "saturday":
                    System.out.println(schedule[6][1]);
                    break;
                case "exit":
                    return;
                case "change":
                    boolean findDay = false;
                    for (int i = 0; i < schedule.length; i++) {
                        if (days[1].equalsIgnoreCase(schedule[i][0])) {
                            System.out.println("Please, input new tasks for " + schedule[i][0]);
                            String data = input.nextLine();
                            schedule[i][1] = data;
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
    private static void newSchedule(String[][] schedule) {
        schedule[0][0] = "sunday";
        schedule[0][1] = "chiil";
        schedule[1][0] = "monday";
        schedule[1][1] = "Go to mall";
        schedule[2][0] = "tuesday";
        schedule[2][1] = "Go to gym";
        schedule[3][0] = "wednesday";
        schedule[3][1] = "Go to pool";
        schedule[4][0] = "thursday";
        schedule[4][1] = "go to courses; watch a film";
        schedule[5][0] = "friday";
        schedule[5][1] = "Go to bar";
        schedule[6][0] = "saturday";
        schedule[6][1] = "Go to parents";
    }
}
