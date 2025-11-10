package java_core_hw_4;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private String[][] schedule = new String[7][2];

    public Human(String name, String surname, int iq, int year, Pet pet) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.year = year;
        setSchedule();
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int iq, int year) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.year = year;
    }

    public Human() {
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }


    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public void greePet() {
        if (family.getPet() != null) {
            System.out.println("Hi, " + family.getPet().getNickName());
        }
    }


    public void describePet() {
        System.out.println("I have a " + family.getPet().getSpecies() + " he is " + family.getPet().getAge() +
                " years old, he" + (family.getPet().getTrickLevel() <= 50 ? " not trick" : " very trick"));
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && Objects.equals(name, human.name) && Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, family);
    }

    @Override
    public String toString() {
        String sceduleString = " ";
        for (int i = 0; i < schedule.length; i++) {
            sceduleString = sceduleString + Arrays.toString(schedule[i]);
        }
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + sceduleString + '}';
    }
    private void setSchedule() {
        for (int i = 0; i < schedule.length; i++) {
            schedule[i][0] = DayOfWeek.values()[i].name();
            schedule[i][1] = DayOfWeek.values()[i].getActivity();
        }
    }
}
