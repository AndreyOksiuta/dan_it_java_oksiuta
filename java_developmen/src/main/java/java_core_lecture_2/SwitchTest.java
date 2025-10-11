package java_core_lecture_2;

import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input you name");
        String text = scanner.nextLine();
        switch (text) {
            case "Andrey":
                System.out.println("Hey Andrey! How are you?");
                break;
            case "Michael":
                System.out.println("Hey Michael! How are you?");
                break;
            default:
                System.out.println("I dont know who are you");

        }
    }
}

