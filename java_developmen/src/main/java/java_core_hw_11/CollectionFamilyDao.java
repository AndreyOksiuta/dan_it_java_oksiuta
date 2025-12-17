package java_core_hw_11;

import java_core_hw_11.family.Family;
import java_core_hw_11.family.Man;
import java_core_hw_11.family.Woman;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> families;

    public CollectionFamilyDao() {
        families = new ArrayList<Family>();
        families.add(new Family(new Woman("Alona", "Andreeya", LocalDate.of(1990, 10, 10)), new Man("Ivan", "Ivanov", LocalDate.of(1990, 10, 10))));
        families.add(new Family(new Woman("Olga", "Andreeya", LocalDate.of(1999, 1, 1)), new Man("Oleg", "Ivanov", LocalDate.of(1990, 2, 2))));
        Family family = new Family(new Woman("Alona", "Ivanova", LocalDate.of(1999, 4, 4)), new Man("Victor", "Ivanov", LocalDate.of(1980, 7, 7)));
        family.addChild(new Man("Petya", "Andreev", LocalDate.of(2025, 5, 5)));
        family.addChild(new Man("Vasia", "Andreeya", LocalDate.of(2018, 9, 9)));
        families.add(family);
        Family family2 = new Family(new Woman("Anna", "Stolyar", LocalDate.of(1995, 9, 21)), new Man("Vasia", "Vasilev", LocalDate.of(1993, 2, 2)));
        family2.addChild(new Woman("Daria", "Andreev", LocalDate.of(2020, 10, 10)));
        family2.addChild(new Man("Artem", "Andreeya", LocalDate.of(2020, 11, 11)));
        families.add(family2);
        loadData(families);
    }


    @Override
    public void loadData(List<Family> familyList) {
        String name = "families.dat";
        try (ObjectOutputStream inputStream = new ObjectOutputStream(new FileOutputStream(name))) {
            inputStream.writeObject(familyList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Family> readFromDocument() {
        List<Family> familyList = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("families.dat"))) {
            familyList = (List<Family>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return familyList;
    }

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int id) {
        if (id > families.size() - 1) {
            return null;
        }
        return families.get(id);
    }

    @Override
    public boolean deleteFamily(int id) {
        if (id > families.size() - 1) {
            return false;
        }
        families.remove(id);
        loadData(families);
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        if (!families.contains(family)) {
            return false;
        }
        families.remove(family);
        loadData(families);
        return true;
    }

    @Override
    public void saveFamily(Family family) {
        if (families.contains(family)) {
            families.set(families.indexOf(family), family);
            loadData(families);
        } else {
            families.add(family);
            loadData(families);
        }
    }
}
