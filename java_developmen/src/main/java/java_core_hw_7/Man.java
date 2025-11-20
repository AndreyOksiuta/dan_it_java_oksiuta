package java_core_hw_7;

import java.time.LocalDate;
import java.util.Objects;

public final class Man extends Human {
    private Family family;

    public Man(String name, String surname, LocalDate birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Man(String name, String surname) {
        super(name, surname);
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Man(String name, String surname, int year) {
        super(name, surname);
    }

    public void repairCar() {
        System.out.println("Sorry im busy, Repair car");
    }

    public void greetPet() {
        String hiToPet = "";
        for (Pet pet : family.getPets()) {
            hiToPet = hiToPet + " Hi " + pet.getNickName() + ", ";
        }
        System.out.println("Hi my friend " + hiToPet);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return Objects.equals(family, man.family);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(family);
    }

    @Override
    public String toString() {
        return "Man{" + super.toString() + '}';
    }
}
