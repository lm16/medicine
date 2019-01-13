package dao.impl;

import dao.MedicineDao;
import dbutils.C3P0Utils;
import domain.Medicine;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.ArrayList;
import java.util.List;

public class MedicineDaoImpl implements MedicineDao {

    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public List<Medicine> getList() {
        List<Medicine> list = new ArrayList<>();
        String sql = "select * from medicine";
        try{
            list = qr.query(sql, new BeanListHandler<>(Medicine.class));
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Medicine getBean(int mno) {
        Medicine medicine = null;
        String sql = "select * from medicine where mno = ?";
        try{
            medicine = qr.query(sql, new BeanHandler<>(Medicine.class), mno);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(Medicine medicine) {
        String sql = "insert into medicine(mno, mname, mmode, mefficacy)values(?, ?, ?, ?)";
        try{
            qr.update(sql, medicine.getMno(), medicine.getMname(), medicine.getMmode(), medicine.getMefficacy());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int mno) {
        String sql = "delete from medicine where mno = ?";
        try{
            qr.update(sql, mno);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
