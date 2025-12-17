package java_core_hw_10.family;

import java.time.LocalDate;

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
    public String prettyFormat() {
        return super.prettyFormat();
    }

    @Override
    public String toString() {
        return "Woman{" + super.toString() +
                '}';
    }
}
