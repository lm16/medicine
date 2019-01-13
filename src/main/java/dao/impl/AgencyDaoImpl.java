package dao.impl;

import dao.AgencyDao;
import dbutils.C3P0Utils;
import domain.Agency;
import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.ArrayList;
import java.util.List;

public class AgencyDaoImpl implements AgencyDao {

    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    public List<Agency> getList() {
        List<Agency> list = new ArrayList<>();
        String sql = "select * from agency";
        try{
            list = qr.query(sql, new BeanListHandler<>(Agency.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Agency getBean(int ano) {
        Agency agency = null;
        String sql = "select * from agency where ano = ?";
        try {
            agency = qr.query(sql, new BeanHandler<>(Agency.class), ano);
        }catch (Exception e){
            e.printStackTrace();
        }
        return agency;
    }

    public void create(Agency agency) {
        String sql = "insert into agency(aname, asex, aphone, aremark) values (?, ?, ?, ?)";
        try{
            qr.update(sql, agency.getAname(), agency.getAsex(), agency.getAphone(), agency.getAremark());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(int ano) {
        String sql = "delete from agency where ano=?";
        try{
            qr.update(sql, ano);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Agency agency) {
        String sql = "update agency set aname=?, asex=?, aphone=?, aremark=? where ano=?";
        try{
            qr.update(sql, agency.getAname(), agency.getAsex(), agency.getAphone(), agency.getAremark(), agency.getAno());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
