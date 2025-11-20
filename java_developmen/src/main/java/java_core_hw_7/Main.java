package java_core_hw_7;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);

        Woman woman = new Woman("Alona", "Petrova");
        Man man = new Man("Petya", "Petrov", LocalDate.of(2000, 11, 22), 111);
        Family family = new Family(woman, man);
        Fish fish = new Fish("Bul bul", 1);
        family.addPet(fish);
        System.out.println(family);

        Man children = new Man("Vasia", "Petrov");
        Woman childrenWoman = new Woman("Olia", "Petrova");
        family.addChild(children);
        family.addChild(childrenWoman);
        System.out.println(family);

        family.deleteChild(children);
        System.out.println(family);

        DomesticCat cat = new DomesticCat("Pusok", 3);
        family.addPet(cat);
        System.out.println(family);

        woman.greetPet();

        man.describeAge();
    }
}
