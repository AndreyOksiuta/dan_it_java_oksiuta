package java_core_hw_10.family;


import java.util.Objects;
import java.util.Set;

public class RoboCat extends Pet {

    private int trickLevel;
    private Set<String> habits;

    public RoboCat(String nickName, int age, int trickLevel, Set<String> habits) {
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

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
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
        return Objects.hash(trickLevel, habits, super.getNickName());
    }

    @Override
    public String toString() {
        return "RoboCat{" + super.toString() +
                "trickLevel=" + trickLevel +
                ", habits=" + habits +
                '}';
    }

    @Override
    void respond() {
        System.out.println("My name is" + getNickName());
    }
}
