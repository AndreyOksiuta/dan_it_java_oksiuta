package java_core_hw_4;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Family family;
    private String[][] schedule = new String[7][2];

    public Human(String name, String surname, int iq, int year, Pet pet) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.year = year;
        this.pet = pet;
        setScedule();
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

    private void setScedule() {
        for (int i = 0; i < schedule.length; i++) {
            schedule[i][0] = DayOfWeek.values()[i].name();
            schedule[i][1] = DayOfWeek.values()[i].getActivity();
        }
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


    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && Objects.equals(name, human.name) && Objects.equals(surname, human.surname);
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


    public void greePet() {
        if (pet != null) {
            System.out.println("Hi, " + pet.getNickName());
        }
    }


    public void describePet() {
        System.out.println("I have a " + pet.getSpecies() + " he is " + pet.getAge() +
                " years old, he" + (pet.getTrickLevel() <= 50 ? " not trick" : " very trick"));
    }
}
