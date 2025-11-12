package java_core_hw_6;

import java.util.HashMap;

public abstract class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private HashMap<String, String> schedule = new HashMap<>();

    public Human(String name, String surname, int year, int iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        setSchedule();
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
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

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                '}';
    }

    private void setSchedule() {
        for (int i = 0; i <= 6; i++) {
            schedule.put(DayOfWeek.values()[i].name(), DayOfWeek.values()[i].getActivity());
        }
    }
}
