package java_core_lecture_1;

public class Variables {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        System.out.println(a+b);
        byte byteVariables=1;
        System.out.println(byteVariables);
        String str="1";
        System.out.println(str+1);
        System.out.println("1"+1+1);
        System.out.println(1+1+"1");
        char charVariables=123;
        System.out.println(charVariables);
        char charVariables2='c';
        System.out.println((int) charVariables2);
        byteVariables=(byte) a;
    }
}
