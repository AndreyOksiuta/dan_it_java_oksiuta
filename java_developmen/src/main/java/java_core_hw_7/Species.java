package java_core_hw_7;

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
