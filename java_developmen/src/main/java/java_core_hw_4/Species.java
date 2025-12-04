package java_core_hw_4;

public enum Species {
    CAT("Cat"),

    DOG("Dog"),

    PARROT("Parrot");

    private final String name;

    Species(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
