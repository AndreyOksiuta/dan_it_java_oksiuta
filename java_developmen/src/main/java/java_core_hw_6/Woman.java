package java_core_hw_6;

import java.util.Objects;

public final class Woman extends Human {

    private Family family;

    public Woman(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    public Woman(String name, String surname, int year, Pet pet) {
        super(name, surname, year);

    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }


    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void greetPet() {
        String hiToPet = "";
        for (Pet pet : family.getPets()) {
            hiToPet = hiToPet + "Hi " + pet.getNickName() + ", ";
        }
        System.out.println(" Hi my little friend " + hiToPet);
    }

    public void makeup() {
        System.out.println("Sorry im busy, i go made makeup");
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Woman woman = (Woman) o;
        return Objects.equals(family, woman.family);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(family);
    }

    @Override
    public String toString() {
        return "Woman{" + super.toString() +
                "pet=" + family.getPets() +
                '}';
    }
}
