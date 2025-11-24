package java_core_hw_8;

import java_core_hw_8.family.Dog;
import java_core_hw_8.family.Man;
import java_core_hw_8.family.Woman;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyController familyController = new FamilyController(new FamilyService(new CollectionFamilyDao()));

        familyController.displayAllFamilies();
        System.out.println(familyController.getFamilyById(3));
        System.out.println(familyController.getAllFamilies());

        System.out.println("getFamiliesBigger/smallThan");
        System.out.println(familyController.getFamiliesBiggerThan(3));
        System.out.println(familyController.getFamiliesLessThan(3));

        System.out.println("countFamiliesWithMemberNumber");
        System.out.println(familyController.countFamiliesWithMemberNumber(4));

        System.out.println("createNewFamily");
        familyController.createNewFamily(new Man("Vasia", "Vasilev", LocalDate.of(1990, 1, 1)), new Woman("Maria", "Vasilev", LocalDate.of(1990, 2, 2)));
        familyController.displayAllFamilies();

//        System.out.println("bornChild");
//        familyController.bornChild(familyController.getFamilyById(0), "Oleg", "Varvara");
//        familyController.displayAllFamilies();
//
//        System.out.println("adoptChild");
//        familyController.adoptChild(familyController.getFamilyById(0), new Woman("Maria", "Vasileva", LocalDate.of(2022, 2, 2)));
//        System.out.println(familyController.getAllFamilies());

        System.out.println("count");
        System.out.println(familyController.count());

        System.out.println("addPet");
        familyController.addPet(new Dog("Gavchik", 3), 1);
        familyController.displayAllFamilies();

        System.out.println("getPets");
        System.out.println(familyController.getPets(1));

        System.out.println("deleteAllChildrenOlderThen");
        familyController.deleteAllChildrenOlderThen(4);
        familyController.displayAllFamilies();

        System.out.println("deleteFamilyByIndex");
        familyController.deleteFamilyByIndex(4);
        familyController.displayAllFamilies();


    }
}
