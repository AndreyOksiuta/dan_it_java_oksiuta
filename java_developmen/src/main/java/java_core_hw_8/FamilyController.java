package java_core_hw_8;

import java_core_hw_8.family.*;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyController {
    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
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
        return familyService.bornChild(family, boyName, girlName);
    }

    public Family adoptChild(Family family, Human human) {
        return familyService.adoptChild(family, human);
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
}
