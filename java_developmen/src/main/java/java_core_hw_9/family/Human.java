package java_core_hw_9.family;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Objects;

public abstract class Human {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private int iq;
    private HashMap<String, String> schedule = new HashMap<>();


    public Human(String name, String surname, int iq, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.birthDate = birthDate;
        setSchedule();
    }

    public Human(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        setSchedule();
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
        setSchedule();
    }

    private Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public void getSchedule() {
        System.out.println(schedule);
    }

    void greetPet() {
    }

    public int getNumberOfYears() {
        Period period = Period.between(birthDate, LocalDate.now());
        return period.getYears();
    }

    public void describeAge() {
        Period period = Period.between(birthDate, LocalDate.now());
        System.out.println(period.getYears() + "-year "
                + period.getMonths() + "-month "
                + period.getDays() + "-day");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(birthDate, human.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth date" + birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyy")) +
                ", iq=" + iq +
                '}';
    }

    public String prettyFormat() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth date-" + birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyy")) +
                ", iq=" + iq;
    }

    private void setSchedule() {
        for (int i = 0; i <= 6; i++) {
            schedule.put(DayOfWeek.values()[i].name(), DayOfWeek.values()[i].getActivity());
        }
    }
}
