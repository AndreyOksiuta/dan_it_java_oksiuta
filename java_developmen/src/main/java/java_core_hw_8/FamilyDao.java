package java_core_hw_8;

import java_core_hw_8.family.Family;

import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();

    Family getFamilyByIndex(int id);

    boolean deleteFamily(int id);

    boolean deleteFamily(Family family);

    void saveFamily(Family family);
}
