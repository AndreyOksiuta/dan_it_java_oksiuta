package java_core_hw_5;

import java.util.Objects;

public final class Woman extends Human {

    public Woman(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    public Woman(String name, String surname, int year, Pet pet) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }


    public void greetPet() {
        System.out.println("Hi my little friend " + getFamily().getPet().getNickName());
    }

    public void makeup() {
        System.out.println("Sorry im busy, i go made makeup");
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
        return "Woman{" + super.toString() +
                "pet=" + getFamily().getPet().getNickName() +
                '}';
    }
}
