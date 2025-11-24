package java_core_hw_8.family;

public enum Species {

    DOMESTICCAT("DomesticCat"),

    DOG("Dog"),

    FISH("Fish"),

    ROBOTCAT("RoboCat"),

    UNKNOWN("Unknown");

    private final String name;

    Species(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
