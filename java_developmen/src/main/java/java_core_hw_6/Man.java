package java_core_hw_6;

import java.util.Objects;

public final class Man extends Human {
    private Pet pet;

    public Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    public Man(String name, String surname, int year, Pet pet) {
        super(name, surname, year);
        this.pet = pet;
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void repairCar() {
        System.out.println("Sorry im busy, Repair car");
    }

    public void greetPet() {
        System.out.println("Hi my friend " + pet.getNickName());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return Objects.equals(pet, man.pet) && super.getName().equals(((Man) o).getName()) && super.getSurname().equals(((Man) o).getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(pet, super.getName(), super.getSurname());
    }

    @Override
    public String toString() {
        return "Man{" + super.toString() +
                "pet=" + pet +
                '}';
    }
}
