package java_core_hw_5;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);

        Woman woman=new Woman("Alona","Petrova",1990);
        woman.setPet(dog);
        System.out.println(woman);

        Fish fish=new Fish("Bul bul",1);
        System.out.println(fish);

        Man man=new Man("Petya","Petrov",1980);
        man.setPet(fish);
        System.out.println(man);

        man.greetPet();
    }
}
