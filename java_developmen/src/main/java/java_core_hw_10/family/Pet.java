package java_core_hw_10.family;

public abstract class Pet {
    private String nickName;
    private Species species = Species.UNKNOWN;
    private int age;

    Pet(String nickName, int age, Species species) {
        this.species = species;
        this.nickName = nickName;
        this.age = age;
    }

    Pet(String nickName, int age) {
        this.nickName = nickName;
        this.age = age;
    }

    Pet() {
    }

    Pet(Species species) {
        this.species = species;
    }
    public String prettyFormat(){
        return "nickName='" + nickName + '\'' +
                ", species=" + species +
                ", age=" + age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nickName='" + nickName + '\'' +
                ", species=" + species +
                ", age=" + age +
                '}';
    }

    public String getNickName() {
        return nickName;
    }

    void eat() {
        System.out.println("My name is " + nickName + " I am eating");
    }

    ;

    abstract void respond();
}
