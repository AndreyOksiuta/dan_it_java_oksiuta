package java_core_hw_9;

import java_core_hw_9.family.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public void displayAllFamilies() {
        List<Family> families = familyDao.getAllFamilies();
        for (int i = 1; i <= families.size(); i++) {
            System.out.println(i + "-" + families.get(i - 1).prettyFormat());
        }
    }

    public void displayAllFamilies(List<Family> families) {
        for (int i = 1; i <= families.size(); i++) {
            System.out.println(i + "-" + families.get(i - 1).prettyFormat());
        }
    }

    public Family getFamilyByIndex(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int max) {
        List<Family> families = familyDao.getAllFamilies();
        return families.stream().filter(family -> family.sizeFamily() > max).collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int min) {
        List<Family> families = familyDao.getAllFamilies();
        return families.stream().filter(family -> family.sizeFamily() < min).collect(Collectors.toList());
    }

    public int countFamiliesWithMemberNumber(int countMemberNumber) {
        List<Family> families = familyDao.getAllFamilies();
        return families.stream().filter(family -> family.sizeFamily() == countMemberNumber).collect(Collectors.toList()).size();
    }

    public void createNewFamily(Human man, Human woman) {
        familyDao.saveFamily(new Family((Woman) woman, (Man) man));
    }

    public Family bornChild(Family family, String boyName, String girlName) throws FamilyOverflowExceptio {
        Random random = new Random();
        int randomN = random.nextInt(2);
        Human human;
        if (randomN == 0) {
            human = new Man(boyName, family.getFather().getSurname(), LocalDate.now());
        } else {
            human = new Woman(girlName, family.getFather().getSurname(), LocalDate.now());
        }
        family.addChild(human);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human human) throws FamilyOverflowExceptio {
        family.addChild(human);
        familyDao.saveFamily(family);
        return family;
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public void deleteAllChildrenOlderThen(int age) {
        List<Family> families = familyDao.getAllFamilies();
        families.forEach(family ->
                family.getChildren().removeIf(child -> child.getNumberOfYears() > age));
        for (Family family : families) {
            familyDao.saveFamily(family);
        }

    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int id) {
        return familyDao.getFamilyByIndex(id);
    }

    public Set<Pet> getPets(int index) {
        return familyDao.getFamilyByIndex(index).getPets();
    }

    public void addPet(Pet pet, int index) {
        Family family = familyDao.getFamilyByIndex(index);
        if (family != null) {
            family.addPet(pet);
            familyDao.saveFamily(family);
        }
    }
}
