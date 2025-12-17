package java_core_hw_11.family;


import java.util.Objects;
import java.util.Set;

public class DomesticCat extends Pet implements Foul {
    private int trickLevel;
    private Set<String> habits;

    public DomesticCat(String nickName, int age, int trickLevel, Set<String> habits) {
        super(nickName, age, Species.DOMESTICCAT);
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public DomesticCat(String nickName, int age) {
        super(nickName, age, Species.DOMESTICCAT);
    }

    public DomesticCat() {
        super(Species.DOMESTICCAT);
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    @Override
    void respond() {
        System.out.println("My name is" + getNickName());
    }

    @Override
    public void foul() {
        System.out.println("Im not sorry, i made foul)))");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DomesticCat that = (DomesticCat) o;
        return trickLevel == that.trickLevel && Objects.deepEquals(habits, that.habits) && super.getNickName().equals(((DomesticCat) o).getNickName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(trickLevel, super.getNickName());
    }

    @Override
    public String toString() {
        return "DomesticCat{" + super.toString() +
                "trickLevel=" + trickLevel +
                ", habits=" + habits +
                '}';
    }
}
