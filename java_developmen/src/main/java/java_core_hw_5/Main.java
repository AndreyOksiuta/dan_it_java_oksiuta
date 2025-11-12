package java_core_hw_5;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);

        Woman woman = new Woman("Alona", "Petrova", 1990);
        Man man = new Man("Petya", "Petrov", 1980);
        Man child = new Man("Oleg", "Petrov", 2001);
        Fish fish = new Fish("Bul bul", 1);
        Family family = new Family(woman, man);
        family.addChild(child);
        family.setPet(fish);
        System.out.println(family);

        family.deleteChild(0);
        System.out.println(family);

        man.greetPet();
    }
}
