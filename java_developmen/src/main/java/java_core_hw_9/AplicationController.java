package java_core_hw_9;

import java_core_hw_9.family.Human;
import java_core_hw_9.family.Man;
import java_core_hw_9.family.Woman;

import java.time.LocalDate;
import java.util.Scanner;

public class AplicationController {
    private Scanner scanner = new Scanner(System.in);
    private FamilyController familyController = new FamilyController(new FamilyService(new CollectionFamilyDao()));

    public void start() {
        while (true) {
            System.out.println("Choose option");
            printOption();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    familyController.displayAllFamilies();
                    break;
                case "2":
                    System.out.println("Input number for filter");
                    String number = scanner.nextLine();
                    familyController.displayAllFamilies(familyController.getFamiliesBiggerThan(Integer.parseInt(number)));
                    break;
                case "3":
                    System.out.println("Input number for filter");
                    number = scanner.nextLine();
                    familyController.displayAllFamilies(familyController.getFamiliesLessThan(Integer.parseInt(number)));
                    break;
                case "4":
                    System.out.println("Input number for filter");
                    number = scanner.nextLine();
                    System.out.println(familyController.countFamiliesWithMemberNumber(Integer.parseInt(number)));
                    break;
                case "5":
                    dataForCreateFamily();
                    break;
                case "6":
                    familyController.deleteFamilyByIndex(inputIndexForDelete());
                    break;
                case "7":
                    System.out.println("1-born child, 2-adopt child");
                    try {
                        int index = Integer.parseInt(scanner.nextLine());
                        if (index < 1 || index > 2) {
                            System.out.println("wrong");
                        }
                        if (index == 1) {
                            bornChild();
                        } else adoptChild();

                    } catch (Exception e) {
                        System.out.println("Invalid index");
                    }
                    break;
                case "8":
                    System.out.println("Input year for delete child");
                    try {
                        int year = Integer.parseInt(scanner.nextLine());
                        familyController.deleteAllChildrenOlderThen(year);
                    } catch (Exception e) {
                        System.out.println("Invalid year");
                    }
                    break;
                case "9":
                    return;

            }
        }
    }

    private void adoptChild() {
        while (true) {
            System.out.println("Input number family for adopt child");
            int index = Integer.parseInt(scanner.nextLine());
            if (index > familyController.count()) {
                System.out.println("Family not exist");
            } else {
                System.out.println("Choose gender of the child 1-boy 2-girl");
                int gender = Integer.parseInt(scanner.nextLine());
                if (gender < 1 || gender > 2) {
                    System.out.println("Wrong gender");
                } else {
                    Human human = inputDataForAdoptChild(gender);
                    familyController.adoptChild(familyController.getFamilyByIndex(index - 1), human);
                    return;
                }
            }
        }
    }

    private Human inputDataForAdoptChild(int gender) {
        Human human;
        System.out.println("input name children");
        String name = scanner.nextLine();
        System.out.println("inpup surname children");
        String surname = scanner.nextLine();
        int yearOfBirth = inputYearOfBirthday();
        int monthOfBirth = inputMonthOfBirthday();
        int dayOfBirth = inputDayOfBirthday();
        int iq = inputIq();
        if (gender == 1) {
            human = new Man(name, surname, LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth), iq);
        } else human = new Woman(name, surname, LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth), iq);
        return human;
    }

    private void bornChild() {
        while (true) {
            System.out.println("Input number family for born child");
            int index = Integer.parseInt(scanner.nextLine());
            if (index > familyController.count()) {
                System.out.println("Famali not exist");
            } else {
                System.out.println("Input name for boy");
                String nameBoy = scanner.nextLine();
                System.out.println("Input name for girl");
                String nameGirl = scanner.nextLine();
                familyController.bornChild(familyController.getFamilyByIndex(index - 1), nameBoy, nameGirl);
                return;
            }
        }
    }

    private int inputIndexForDelete() {
        int index;
        while (true) {
            System.out.println("Input index for delete");
            try {
                index = Integer.parseInt(scanner.nextLine());
                if (index > familyController.count()) {
                    System.out.println("Invalid index");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid data");
            }
        }
        return index - 1;
    }

    private void dataForCreateFamily() {
        System.out.println("Input name mother");
        String motherName = scanner.nextLine();
        System.out.println("Input surname mother");
        String motherSurname = scanner.nextLine();
        int yearOfBirthdayMother = inputYearOfBirthday();
        int monthOfBirthdayMother = inputMonthOfBirthday();
        int dayOfBirthdayMother = inputDayOfBirthday();
        int iqMother = inputIq();
        System.out.println("Input name father");
        String fatherName = scanner.nextLine();
        System.out.println("Input surname father");
        String fatherSurname = scanner.nextLine();
        int yearOfBirthdayFather = inputYearOfBirthday();
        int monthOfBirthdayFather = inputMonthOfBirthday();
        int dayOfBirthdayFather = inputDayOfBirthday();
        int iqFather = inputIq();
        familyController.createNewFamily(new Man(fatherName, fatherSurname, LocalDate.of(yearOfBirthdayFather, monthOfBirthdayFather, dayOfBirthdayFather), iqFather),
                new Woman(motherName, motherSurname, LocalDate.of(yearOfBirthdayMother, monthOfBirthdayMother, dayOfBirthdayMother), iqMother));
    }

    private int inputYearOfBirthday() {
        int yearOfBirthday;
        while (true) {
            System.out.println("Input year of birthday mother");
            try {
                yearOfBirthday = Integer.parseInt(scanner.nextLine());
                if (yearOfBirthday < 1900 || yearOfBirthday > LocalDate.now().getYear()) {
                    System.out.println("Invalid year of birthday mother");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input data of birthday mother");
            }
        }
        return yearOfBirthday;
    }

    private int inputMonthOfBirthday() {
        int monthOfBirthday;
        while (true) {
            System.out.println("Input month of birthday mother");
            try {
                monthOfBirthday = Integer.parseInt(scanner.nextLine());
                if (monthOfBirthday < 1 || monthOfBirthday > 12) {
                    System.out.println("Invalid year of birthday mother");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input data of birthday mother");
            }
        }
        return monthOfBirthday;
    }

    private int inputDayOfBirthday() {
        int dayOfBirthday;
        while (true) {
            System.out.println("Input day of birthday mother");
            try {
                dayOfBirthday = Integer.parseInt(scanner.nextLine());
                if (dayOfBirthday < 1 || dayOfBirthday > 31) {
                    System.out.println("Invalid year of birthday mother");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input data of birthday mother");
            }
        }
        return dayOfBirthday;
    }

    private int inputIq() {
        int iq;
        while (true) {
            System.out.println("Input iq");
            try {
                iq = Integer.parseInt(scanner.nextLine());
                if (iq < 1 || iq > 200) {
                    System.out.println("Invalid iq");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input data of iq");
            }
        }
        return iq;
    }

    private void printOption() {
        String option = "1-display all families\n" +
                "2-display families biggest number\n" +
                "3-display families smallest number\n" +
                "4-count families where size is number\n" +
                "5-create new family\n" +
                "6-delete family by index\n" +
                "7-update family\n" +
                "8-delete all children older year\n" +
                "9-exit";
        System.out.println(option);
    }
}
