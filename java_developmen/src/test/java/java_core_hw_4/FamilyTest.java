package java_core_hw_4;

import org.junit.Assert;
import org.junit.Test;

public class FamilyTest {
    @Test
    public void deleteChildTest() {
        Human mother = new Human("Olga", "Petrova", 1980);
        Human father = new Human("Petya", "Petrov", 1980);
        Human son = new Human("Vasia", "Petrov", 1999);
        Human son2 = new Human("Petya", "Petrov", 1995);
        Family family = new Family(mother, father);
        family.addChild(son);
        family.addChild(son2);

        boolean booleanAfterDeletChild = family.deleteChild(1);
        boolean booleanExpected = true;

        Assert.assertEquals(booleanExpected, booleanAfterDeletChild);
    }

    @Test
    public void deleteChildTestWrongIndex() {
        Human mother = new Human("Olga", "Petrova", 1980);
        Human father = new Human("Petya", "Petrov", 1980);
        Human son = new Human("Vasia", "Petrov", 1999);
        Human son2 = new Human("Petya", "Petrov", 1995);
        Family family = new Family(mother, father);
        family.addChild(son);
        family.addChild(son2);

        boolean booleanAfterDeletChild = family.deleteChild(3);
        boolean booleanExpected = false;

        Assert.assertEquals(booleanExpected, booleanAfterDeletChild);
    }

    @Test
    public void addChildTest() {
        Human mother = new Human("Olga", "Petrova", 1980);
        Human father = new Human("Petya", "Petrov", 1980);
        Human son = new Human("Vasia", "Petrov", 1999);
        Human son2 = new Human("Petya", "Petrov", 1995);
        Family family = new Family(mother, father);
        family.addChild(son);
        family.addChild(son2);

        int sizeChildrenArray = family.getChildren().length;
        int expectedSize = 2;

        Assert.assertEquals(expectedSize, sizeChildrenArray);
    }

    @Test
    public void sizeFamilyTest() {
        Human mother = new Human("Olga", "Petrova", 1980);
        Human father = new Human("Petya", "Petrov", 1980);
        Human son = new Human("Vasia", "Petrov", 1999);
        Human son2 = new Human("Petya", "Petrov", 1995);
        Family family = new Family(mother, father);
        family.addChild(son);
        family.addChild(son2);

        int sizeFamilyFomClass = family.sizeFamily();
        int expectedSize = 4;

        Assert.assertEquals(expectedSize, sizeFamilyFomClass);
    }
}