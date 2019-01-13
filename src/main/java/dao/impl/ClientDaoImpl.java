package dao.impl;

import dao.ClientDao;
import dbutils.C3P0Utils;
import domain.Client;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public List<Client> getList() {
        List<Client> list = new ArrayList<>();
        String sql = "select * from client";
        try{
            list = qr.query(sql, new BeanListHandler<>(Client.class));
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Client getBean(int cno) {
        Client client = null;
        String sql = "select * from client where cno=?";
        try{
            client = qr.query(sql, new BeanHandler<>(Client.class), cno);
        }catch (Exception e){
            e.printStackTrace();
        }

        return client;
    }

    @Override
    public void create(Client client) {
        String sql = "insert into client(cname, csex, cage, caddress, cphone, csymptom, mno, cno, cdate, cremark) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            qr.update(sql, client.getCname(), client.getCsex(), client.getCage(), client.getCaddress(), client.getCphone(), client.getCsymptom(), client.getMno(), client.getCno(), client.getCdate(), client.getCremark());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int cno) {
        String sql = "delete from client where cno=?";
        try{
            qr.update(sql, cno);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
