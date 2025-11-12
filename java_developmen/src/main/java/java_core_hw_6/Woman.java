package java_core_hw_6;

import java.util.Objects;

public final class Woman extends Human {
    private Pet pet;

    public Woman(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    public Woman(String name, String surname, int year, Pet pet) {
        super(name, surname, year);
        this.pet = pet;
    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void greetPet() {
        System.out.println("Hi my little friend " + pet.getNickName());
    }

    public void makeup() {
        System.out.println("Sorry im busy, i go made makeup");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Woman woman = (Woman) o;
        return Objects.equals(pet, woman.pet) && super.getName().equals(((Woman) o).getName()) && super.getSurname().equals(((Woman) o).getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(pet, super.getName(), super.getSurname());
    }

    @Override
    public String toString() {
        return "Woman{" + super.toString() +
                "pet=" + pet +
                '}';
    }
}
