package java_core_hw_4;

import junit.framework.TestCase;

public class HumanTest extends TestCase {

    public void testTestGetName() {
        String name="Petya";
        String surname="Petrov";
        int age=1990;
        Human human=new Human(name,surname,age);
        String expected="Petya";
        String actual=human.getName();
        assertEquals(expected,actual);

    }


    public void testTestToString() {
        String name="Petya";
        String surname="Petrov";
        int age=1990;
        Human human=new Human(name,surname,age);
        String expected="Human{name='Petya', surname='Petrov', year=1990, iq=0, schedule= [null, null][null, null][null, null][null, null][null, null][null, null][null, null]}";
        String actual=human.toString();
        assertEquals(expected,actual);
    }
}