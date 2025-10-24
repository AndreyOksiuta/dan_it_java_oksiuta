package java_core_hw_4;

import junit.framework.TestCase;

public class FamilyTest extends TestCase {

    public void testAddChild() {
        Human mother = new Human("Olga","Petrova",1980);
        Human father = new Human("Petya","Petrov",1980);
        Human son=new Human("Vasia","Petrov",1999);
        Family family=new Family(mother,father);
        family.addChild(son);
        Human expected=son;
        Human actual=family.getChildren()[0];
        int expectedSizeArray=1;
        int actualSizeArray=family.getChildren().length;
        assertEquals(expected,actual);
        assertEquals(expectedSizeArray,actualSizeArray);

    }

    public void testDeleteChild() {
        Human mother = new Human("Olga","Petrova",1980);
        Human father = new Human("Petya","Petrov",1980);
        Human son=new Human("Vasia","Petrov",1999);
        Human son2=new Human("Petya","Petrov",1995);
        Family family=new Family(mother,father);
        family.addChild(son);
        family.addChild(son2);
        boolean expected=true;
        boolean actual=family.deleteChild(1);
        boolean expected2=false;
        boolean actual2=family.deleteChild(3);
        assertEquals(expected,actual);
        assertEquals(expected2,actual2);
    }

    public void testSizeFamily() {
        Human mother = new Human("Olga","Petrova",1980);
        Human father = new Human("Petya","Petrov",1980);
        Human son=new Human("Vasia","Petrov",1999);
        Human son2=new Human("Petya","Petrov",1995);
        Family family=new Family(mother,father);
        family.addChild(son);
        family.addChild(son2);
        int  expected=4;
        int actual=family.sizeFamily();
        assertEquals(expected,actual);
    }
}