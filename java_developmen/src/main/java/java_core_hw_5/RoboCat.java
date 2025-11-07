package java_core_hw_5;

import java.util.Arrays;
import java.util.Objects;

public class RoboCat extends Pet {

    private int trickLevel;
    private String[] habits;

    public RoboCat(String nickName, int age, int trickLevel, String[] habits) {
        super(nickName, age, Species.ROBOTCAT);
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public RoboCat(String nickName, int age) {
        super(nickName, age, Species.ROBOTCAT);
    }

    public RoboCat() {
        super(Species.ROBOTCAT);
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoboCat roboCat = (RoboCat) o;
        return trickLevel == roboCat.trickLevel && Objects.deepEquals(habits, roboCat.habits) && super.getNickName().equals(((RoboCat) o).getNickName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(trickLevel, Arrays.hashCode(habits), super.getNickName());
    }

    @Override
    public String toString() {
        return "RoboCat{" + super.toString() +
                "trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

    @Override
    void respond() {
        System.out.println("My name is" + getNickName());
    }
}
