package java_core_hw_4;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children = new Human[0];
    private Pet pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public void addChild(Human child) {
        child.setFamily(this);
        Human[] childrenNew = new Human[this.children.length + 1];
        System.arraycopy(this.children, 0, childrenNew, 0, this.children.length);
        childrenNew[children.length] = child;
        children = childrenNew;
    }

    public boolean deleteChild(int index) {
        if (index >= this.children.length || index < 0) {
            System.out.println("Index out of range");
            return false;
        }
        Human[] childrenNew = new Human[this.children.length - 1];
        for (int j = 0; j < children.length; j++) {
            if (j == index) {
                continue;
            }
            childrenNew[j] = this.children[j];
        }
        children = childrenNew;
        return true;
    }

    public int sizeFamily() {
        return children.length + 2;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, Arrays.hashCode(children), pet);
    }

    @Override
    public String toString() {
        String childString = " ";
        for (int i = 0; i < children.length; i++) {
            childString = childString + children[i].getName() + " " + getChildren()[i].getSurname() + " ";
        }
        return "Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() +
                ", father=" + father.getName() + " " + father.getSurname() +
                ", children=[" + childString + "]" +
                ", pet=" + pet +
                '}';
    }
}
