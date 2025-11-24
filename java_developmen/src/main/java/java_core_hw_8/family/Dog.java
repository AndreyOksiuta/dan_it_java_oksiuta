package java_core_hw_8.family;

import java.util.Objects;
import java.util.Set;

public class Dog extends Pet implements Foul {

    private int trickLevel;
    private Set<String> habits;

    public Dog(String nickName, int age, int trickLevel, Set<String> habits) {
        super(nickName, age, Species.DOG);
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Dog(String nickName, int age) {
        super(nickName, age, Species.DOG);
    }

    public Dog() {
        super(Species.DOG);
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
    void respond() {
        System.out.println("My name is" + getNickName());
    }

    @Override
    public void foul() {
        System.out.println("Im sorry, but i made foul(((");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return trickLevel == dog.trickLevel && Objects.deepEquals(habits, dog.habits) && super.getNickName().equals(((Dog) o).getNickName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(trickLevel, super.getNickName());
    }

    @Override
    public String toString() {
        return "Dog{" + super.toString() +
                "trickLevel=" + trickLevel +
                ", habits=" + habits +
                '}';
    }
}
