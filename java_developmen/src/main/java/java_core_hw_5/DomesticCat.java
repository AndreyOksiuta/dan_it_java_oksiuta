package java_core_hw_5;

import java.util.Arrays;
import java.util.Objects;

public class DomesticCat extends Pet implements Foul {
    private int trickLevel;
    private String[] habits;

    public DomesticCat(String nickName, int age, int trickLevel, String[] habits) {
        super(nickName, age, Species.DOG);
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public DomesticCat(String nickName, int age) {
        super(nickName, age);
    }

    public DomesticCat() {
        super(Species.DOMESTICCAT);
    }


    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DomesticCat that = (DomesticCat) o;
        return trickLevel == that.trickLevel && Objects.deepEquals(habits, that.habits) && super.getNickName().equals(((DomesticCat) o).getNickName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(trickLevel, Arrays.hashCode(habits), super.getNickName());
    }

    @Override
    public String toString() {
        return "DomesticCat{" + super.toString() +
                "trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

    @Override
    void respond() {
        System.out.println("My name is" + getNickName());
    }

    @Override
    public void foul() {
        System.out.println("Im not sorry, i made foul)))");
    }
}
