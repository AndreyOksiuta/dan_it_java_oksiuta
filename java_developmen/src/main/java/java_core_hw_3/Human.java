package java_core_hw_3;

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
        setSchedule();
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        setSchedule();
    }

    public Human(String name, String surname, int iq, int year) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.year = year;
        setSchedule();
    }

    public Human() {
    }

    private void setSchedule() {
        schedule[0][0] = "sunday";
        schedule[0][1] = "chiil";
        schedule[1][0] = "monday";
        schedule[1][1] = "Go to mall";
        schedule[2][0] = "tuesday";
        schedule[2][1] = "Go to gym";
        schedule[3][0] = "wednesday";
        schedule[3][1] = "Go to pool";
        schedule[4][0] = "thursday";
        schedule[4][1] = "go to courses; watch a film";
        schedule[5][0] = "friday";
        schedule[5][1] = "Go to bar";
        schedule[6][0] = "saturday";
        schedule[6][1] = "Go to parents";
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
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family);
    }


    @Override
    public String toString() {
        String scheduleString = " ";
        for (int i = 0; i < schedule.length; i++) {
            scheduleString = scheduleString + Arrays.toString(schedule[i]);
        }
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + scheduleString + '}';
    }


    public void greetPet() {
            System.out.println("Hi, " + pet.getNickName());

    }


    public void describePet() {
        System.out.println("I have a " + pet.getSpecies() + " he is " + pet.getAge() +
                " years old, he" + (pet.getTrickLevel() <= 50 ? " not trick" : " very trick"));
    }
}
