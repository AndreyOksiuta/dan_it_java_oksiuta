package java_core_hw_5;

import java.util.Objects;

public final class Man extends Human {

    public Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    public Man(String name, String surname, int year, Pet pet) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public void repairCar() {
        System.out.println("Sorry im busy, Repair car");
    }

    public void greetPet() {
        System.out.println("Hi my friend " + getFamily().getPet().getNickName());
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Man{" + super.toString() +
                '}';
    }
}
