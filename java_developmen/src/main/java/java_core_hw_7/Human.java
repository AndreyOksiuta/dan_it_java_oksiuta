package java_core_hw_7;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;

public abstract class Human {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private int iq;
    private HashMap<String, String> schedule = new HashMap<>();

    public Human(String name, String surname, LocalDate birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        setSchedule();
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.now();
        setSchedule();
    }

    private Human() {
        this.birthDate = LocalDate.now();
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

    public void describeAge() {
        Period period = Period.between(birthDate, LocalDate.now());
        System.out.println(period.getYears() + "-year " + period.getMonths() + "-month " + period.getDays() + "-day");
    }

    void greetPet() {
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date of birth=" + birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyy")) +
                ", iq=" + iq +
                '}';
    }

    private void setSchedule() {
        for (int i = 0; i <= 6; i++) {
            schedule.put(DayOfWeek.values()[i].name(), DayOfWeek.values()[i].getActivity());
        }
    }
}
