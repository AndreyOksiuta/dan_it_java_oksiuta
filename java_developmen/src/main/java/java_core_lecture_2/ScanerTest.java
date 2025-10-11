package java_core_lecture_2;

import java.util.Scanner;

public class ScanerTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter a text");
        String text=scanner.next();
        System.out.println("number is "+text);
        System.out.println("Enter a number");
        int number=scanner.nextInt();
        System.out.println("Input number"+number);
    }
}
