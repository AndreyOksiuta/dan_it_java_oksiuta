package java_core_hw_11.family;


import java_core_hw_11.FamilyOverflowException;

import java.io.Serializable;
import java.util.*;

public class Family implements Serializable {
    private Woman mother;
    private Man father;
    private List<Human> children = new ArrayList<>();
    private Set<Pet> pets = new HashSet<>();

    public Family(Woman mother, Man father) {
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
    }

    public Woman getMother() {
        return mother;
    }

    public void setMother(Woman mother) {
        this.mother = mother;
    }

    public Man getFather() {
        return father;
    }

    public void setFather(Man father) {
        this.father = father;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void addChild(Human child) {
        if (children.size() == 2) {
            throw new FamilyOverflowException("To big family");
        }
        children.add(child);
    }

    public boolean deleteChild(int index) {
        if (index < 0 && index > children.size()) {
            return false;
        } else children.remove(index);
        return true;
    }

    public boolean deleteChild(Human child) {
        if (children.contains(child)) {
            children.remove(child);
            return true;
        }
        return false;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public boolean removePet(Pet pet) {
        if (pets.contains(pet)) {
            pets.remove(pet);
            return true;
        }
        return false;
    }

    public int sizeFamily() {
        return children.size() + 2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    public String prettyFormat() {
        String childString = " ";
        if (!children.isEmpty()) {
            for (Human child : children) {
                childString = childString + (child.getClass().getSimpleName().equalsIgnoreCase("man") ? "boy: " : "girl: ") + child.prettyFormat() + "\n";
            }
        }
        String petsString = " ";
        if (!pets.isEmpty()) {
            for (Pet pet : pets) {
                petsString = petsString + pet.prettyFormat();
            }
        }
        return "Family{\n" +
                " mother:" + mother.prettyFormat() + "\n" +
                " father:" + father.prettyFormat() + "\n" +
                " children:\n" + childString +
                " pet:" + petsString +
                '}';
    }


    @Override
    public String toString() {
        String childString = " ";
        for (Human child : children) {
            childString = childString + child.getName() + " " + child.getSurname() + ", age-" + child.getNumberOfYears() + ", ";
        }
        return "Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() +
                ", father=" + father.getName() + " " + father.getSurname() +
                ", children=[" + childString + "]" +
                ", pet=" + pets +
                '}';
    }
}
