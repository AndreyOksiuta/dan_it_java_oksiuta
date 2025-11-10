package java_core_hw_4;

public class Main {
    public static void main(String[] args) {
        Human mother = new Human("Olga", "Petrova", 1980);
        Human father = new Human("Petya", "Petrov", 1980);
        Human son = new Human("Vasia", "Petrov", 1999);
        Human son2 = new Human("Petya", "Petrov", 1995);

        Pet pet = new Pet(Species.CAT, "barsik", 5, 51, new String[]{"smile", "fast"});
        System.out.println(son);

        Family family = new Family(mother, father);
        family.addChild(son);
        family.addChild(son2);
        System.out.println(son);
        System.out.println(family);
        System.out.println("family size-" + family.sizeFamily());

        family.deleteChild(1);
        System.out.println(family);
        System.out.println("family size-" + family.sizeFamily());

        Human mother2 = new Human("Alona", "Petrova", 1980);
        Human father2 = new Human("Vasia", "Petrov", 1995);
        Family family2 = new Family(mother2, father2);
        System.out.println(family2);

        Human daughter = new Human("Anya", "Petrova", 2000);

        family2.addChild(daughter);
        System.out.println(family2);
        son.describePet();
        son.greePet();
        pet.foul();
        pet.respond();
    }
}
