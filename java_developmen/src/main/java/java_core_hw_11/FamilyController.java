package java_core_hw_11;

import java_core_hw_11.family.Family;
import java_core_hw_11.family.Human;
import java_core_hw_11.family.Pet;

import java.util.List;
import java.util.Set;

public class FamilyController {
    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public void loadData() {
        List<Family> familyList = familyService.getAllFamilies();
        familyService.loadData(familyList);
    }

    public List<Family> readFromDocument() {
        return familyService.readFromDocument();
    }

    ;

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public void displayAllFamilies(List<Family> families) {
        familyService.displayAllFamilies(families);
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int max) {
        return familyService.getFamiliesBiggerThan(max);
    }

    public List<Family> getFamiliesLessThan(int min) {
        return familyService.getFamiliesLessThan(min);
    }

    public int countFamiliesWithMemberNumber(int countMemberNumber) {
        return familyService.countFamiliesWithMemberNumber(countMemberNumber);
    }

    public void createNewFamily(Human man, Human woman) {
        familyService.createNewFamily(man, woman);
    }

    public Family bornChild(Family family, String boyName, String girlName) {
        try {
            return familyService.bornChild(family, boyName, girlName);
        } catch (FamilyOverflowException e) {
            e.printStackTrace();
            return family;
        }
    }

    public Family adoptChild(Family family, Human human) {
        try {
            return familyService.adoptChild(family, human);
        } catch (FamilyOverflowException e) {
            e.printStackTrace();
            return family;
        }
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int id) {
        return familyService.getFamilyById(id);
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(Pet pet, int index) {
        familyService.addPet(pet, index);
    }

    public Family getFamilyByIndex(int index) {
        return familyService.getFamilyByIndex(index);
    }
}
