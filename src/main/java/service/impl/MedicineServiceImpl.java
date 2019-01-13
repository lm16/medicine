package service.impl;

import dao.MedicineDao;
import dao.impl.MedicineDaoImpl;
import domain.Medicine;
import service.MedicineService;

import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    private MedicineDao medicineDao = new MedicineDaoImpl();

    @Override
    public List<Medicine> getList() {
        return medicineDao.getList();
    }

    @Override
    public Medicine getBean(int mno) {
        return medicineDao.getBean(mno);
    }

    @Override
    public void create(Medicine medicine) {
        medicineDao.create(medicine);
    }

    @Override
    public void delete(int mno) {
        medicineDao.delete(mno);
    }
}
