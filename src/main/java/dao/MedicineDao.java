package dao;

import domain.Medicine;

import java.util.List;

public interface MedicineDao {

    List<Medicine> getList();

    Medicine getBean(int mno);

    void create(Medicine medicine);

    void delete(int mno);

}
