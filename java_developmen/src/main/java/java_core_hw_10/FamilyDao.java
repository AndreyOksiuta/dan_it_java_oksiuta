package java_core_hw_10;

import java_core_hw_10.family.Family;

import java.util.List;

public interface FamilyDao {
    void loadData(List<Family> familyList);
    String readFromTXT();
    List<Family> getAllFamilies();

    Family getFamilyByIndex(int id);

    boolean deleteFamily(int id);

    boolean deleteFamily(Family family);

    void saveFamily(Family family);
}
