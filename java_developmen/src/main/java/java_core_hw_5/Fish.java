package java_core_hw_5;

import java.util.Arrays;
import java.util.Objects;

public class Fish extends Pet {
    private int trickLevel;
    private String[] habits;

    public Fish(String nickName, int age, int trickLevel, String[] habits) {
        super(nickName, age, Species.DOG);
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Fish(String nickName, int age) {
        super(nickName, age,Species.FISH);
    }
    public Fish() {
        super(Species.FISH);
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
        Fish fish = (Fish) o;
        return trickLevel == fish.trickLevel && Objects.deepEquals(habits, fish.habits) && super.getNickName().equals(((Fish) o).getNickName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(trickLevel, Arrays.hashCode(habits), super.getNickName());
    }

    @Override
    public String toString() {
        return "Fish{" + super.toString() +
                "trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

    @Override
    void respond() {
        System.out.println("My name is" + getNickName());
    }
}
