package java_core_hw_4;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class HumanTest {
    @Test
    public void toStringTest() {
        String name="Alona";
        String surname="Ivanova";
        int yearOfBirthd=1990;
        Human human = new Human(name,surname,yearOfBirthd);
        String humanToString=human.toString();
        String expectedHumanToString="Human{name='Alona', surname='Ivanova', year=1990, iq=0, schedule= [null, null][null, null][null, null][null, null][null, null][null, null][null, null]}";
        Assert.assertEquals(expectedHumanToString, humanToString);
    }



}