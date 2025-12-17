package java_core_hw_8;

import java_core_hw_8.family.*;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FamilyServiceTest extends TestCase {


    public void testGetAllFamilies() {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        List<Family> expectedFamilies = new ArrayList<>();

        expectedFamilies.add(new Family(new Woman("Alona", "Andreeya", LocalDate.of(1990, 10, 10)), new Man("Ivan", "Ivanov", LocalDate.of(1990, 10, 10))));
        expectedFamilies.add(new Family(new Woman("Olga", "Andreeya", LocalDate.of(1999, 1, 1)), new Man("Oleg", "Ivanov", LocalDate.of(1990, 2, 2))));
        Family family = new Family(new Woman("Alona", "Ivanova", LocalDate.of(1999, 4, 4)), new Man("Victor", "Ivanov", LocalDate.of(1980, 7, 7)));
        family.addChild(new Man("Petya", "Andreev", LocalDate.of(2025, 5, 5)));
        family.addChild(new Man("Vasia", "Andreeya", LocalDate.of(2018, 9, 9)));
        expectedFamilies.add(family);
        Family family2 = new Family(new Woman("Anna", "Stolyar", LocalDate.of(1995, 9, 21)), new Man("Vasia", "Vasilev", LocalDate.of(1993, 2, 2)));
        family2.addChild(new Man("Daria", "Andreev", LocalDate.of(2020, 10, 10)));
        family2.addChild(new Man("Artem", "Andreeya", LocalDate.of(2020, 11, 11)));
        expectedFamilies.add(family2);

        Assert.assertEquals(expectedFamilies, familyService.getAllFamilies());

    }

    public void testGetFamiliesBiggerThan() {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        List<Family> expectedFamilies = new ArrayList<>();

        Family family = new Family(new Woman("Alona", "Ivanova", LocalDate.of(1999, 4, 4)), new Man("Victor", "Ivanov", LocalDate.of(1980, 7, 7)));
        family.addChild(new Man("Petya", "Andreev", LocalDate.of(2025, 5, 5)));
        family.addChild(new Man("Vasia", "Andreeya", LocalDate.of(2018, 9, 9)));
        expectedFamilies.add(family);
        Family family2 = new Family(new Woman("Anna", "Stolyar", LocalDate.of(1995, 9, 21)), new Man("Vasia", "Vasilev", LocalDate.of(1993, 2, 2)));
        family2.addChild(new Man("Daria", "Andreev", LocalDate.of(2020, 10, 10)));
        family2.addChild(new Man("Artem", "Andreeya", LocalDate.of(2020, 11, 11)));
        expectedFamilies.add(family2);

        Assert.assertEquals(expectedFamilies, familyService.getFamiliesBiggerThan(3));

    }

    public void testGetFamiliesLessThan() {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        List<Family> expectedFamilies = new ArrayList<>();

        expectedFamilies.add(new Family(new Woman("Alona", "Andreeya", LocalDate.of(1990, 10, 10)), new Man("Ivan", "Ivanov", LocalDate.of(1990, 10, 10))));
        expectedFamilies.add(new Family(new Woman("Olga", "Andreeya", LocalDate.of(1999, 1, 1)), new Man("Oleg", "Ivanov", LocalDate.of(1990, 2, 2))));

        Assert.assertEquals(expectedFamilies, familyService.getFamiliesLessThan(3));
    }

    public void testCountFamiliesWithMemberNumber() {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());

        int expectedCount = 2;

        Assert.assertEquals(expectedCount, familyService.countFamiliesWithMemberNumber(2));
    }

    public void testCreateNewFamily() {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        List<Family> expectedFamilies = new ArrayList<>();

        expectedFamilies.add(new Family(new Woman("Alona", "Andreeya", LocalDate.of(1990, 10, 10)), new Man("Ivan", "Ivanov", LocalDate.of(1990, 10, 10))));
        expectedFamilies.add(new Family(new Woman("Olga", "Andreeya", LocalDate.of(1999, 1, 1)), new Man("Oleg", "Ivanov", LocalDate.of(1990, 2, 2))));
        Family family = new Family(new Woman("Alona", "Ivanova", LocalDate.of(1999, 4, 4)), new Man("Victor", "Ivanov", LocalDate.of(1980, 7, 7)));
        family.addChild(new Man("Petya", "Andreev", LocalDate.of(2025, 5, 5)));
        family.addChild(new Man("Vasia", "Andreeya", LocalDate.of(2018, 9, 9)));
        expectedFamilies.add(family);
        Family family2 = new Family(new Woman("Anna", "Stolyar", LocalDate.of(1995, 9, 21)), new Man("Vasia", "Vasilev", LocalDate.of(1993, 2, 2)));
        family2.addChild(new Man("Daria", "Andreev", LocalDate.of(2020, 10, 10)));
        family2.addChild(new Man("Artem", "Andreeya", LocalDate.of(2020, 11, 11)));
        expectedFamilies.add(family2);
        expectedFamilies.add(new Family(new Woman("Olga", "Petrova", LocalDate.of(1980, 3, 12)), new Man("Vasia", "Petov", LocalDate.of(1890, 1, 1))));

        familyService.createNewFamily(new Man("Vasia", "Petov", LocalDate.of(1890, 1, 1)), new Woman("Olga", "Petrova", LocalDate.of(1980, 3, 12)));

        Assert.assertEquals(expectedFamilies, familyService.getAllFamilies());
    }


    public void testAdoptChild() {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Family expectedFamily = new Family(new Woman("Alona", "Ivanova", LocalDate.of(1999, 4, 4)), new Man("Victor", "Ivanov", LocalDate.of(1980, 7, 7)));
        expectedFamily.addChild(new Man("Ivan", "Andreev", LocalDate.of(2025, 5, 5)));
        expectedFamily.addChild(new Man("Vasia", "Andreeya", LocalDate.of(2018, 9, 9)));
        expectedFamily.addChild(new Man("Petya", "Andreev", LocalDate.of(2025, 5, 5)));

        familyService.adoptChild(familyService.getFamilyById(2), new Man("Petya", "Andreev", LocalDate.of(2025, 5, 5)));

        Assert.assertEquals(expectedFamily, familyService.getFamilyById(2));
    }

    public void testDeleteFamilyByIndex() {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        boolean expectedResult = true;

        Assert.assertEquals(expectedResult, familyService.deleteFamilyByIndex(1));
    }

    public void testDeleteAllChildrenOlderThen() {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        List<Family> expectedFamilies = new ArrayList<>();

        expectedFamilies.add(new Family(new Woman("Alona", "Andreeya", LocalDate.of(1990, 10, 10)), new Man("Ivan", "Ivanov", LocalDate.of(1990, 10, 10))));
        expectedFamilies.add(new Family(new Woman("Olga", "Andreeya", LocalDate.of(1999, 1, 1)), new Man("Oleg", "Ivanov", LocalDate.of(1990, 2, 2))));
        Family family = new Family(new Woman("Alona", "Ivanova", LocalDate.of(1999, 4, 4)), new Man("Victor", "Ivanov", LocalDate.of(1980, 7, 7)));
        family.addChild(new Man("Petya", "Andreev", LocalDate.of(2025, 5, 5)));
        expectedFamilies.add(family);
        Family family2 = new Family(new Woman("Anna", "Stolyar", LocalDate.of(1995, 9, 21)), new Man("Vasia", "Vasilev", LocalDate.of(1993, 2, 2)));
        expectedFamilies.add(family2);

        familyService.deleteAllChildrenOlderThen(5);
        Assert.assertEquals(expectedFamilies, familyService.getAllFamilies());

    }

    public void testCount() {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        int expectedResult = 4;

        assertEquals(expectedResult, familyService.count());
    }

    public void testGetFamilyById() {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Family expectedFamily = new Family(new Woman("Alona", "Andreeya", LocalDate.of(1990, 10, 10)), new Man("Ivan", "Ivanov", LocalDate.of(1990, 10, 10)));

        Assert.assertEquals(expectedFamily, familyService.getFamilyById(0));

    }

    public void testGetPets() {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Set<Pet> expectedPets = new HashSet<>();

        Assert.assertEquals(expectedPets, familyService.getFamilyById(1).getPets());
    }

    public void testAddPet() {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Family expectedFamyly = new Family(new Woman("Anna", "Stolyar", LocalDate.of(1995, 9, 21)), new Man("Vasia", "Vasilev", LocalDate.of(1993, 2, 2)));
        expectedFamyly.addPet(new Dog("Gavchik", 3));

        familyService.addPet(new Dog("Gavchik", 3), 3);

        assertEquals(expectedFamyly, familyService.getFamilyById(3));
    }
}