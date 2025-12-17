package java_core_hw_8.family;

import java.time.LocalDate;
import java.util.Objects;

public final class Woman extends Human {

    private Family family;

    public Woman(String name, String surname, LocalDate birthDate, int iq) {
        super(name, surname, iq, birthDate);
    }

    public Woman(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
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


//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Woman woman = (Woman) o;
//        return Objects.equals(family, woman.family);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(family);
//    }

    @Override
    public String toString() {
        return "Woman{" + super.toString() +
                "pet=" + family.getPets() +
                '}';
    }
}
