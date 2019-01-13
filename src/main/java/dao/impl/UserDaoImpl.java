package dao.impl;

import dao.UserDao;
import dbutils.C3P0Utils;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDaoImpl implements UserDao {

    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public String validate(User user) {
        User bean = null;
        String sql = "select * from user where usern=? and passwd=? and type=?";

        try {
            bean = qr.query(sql, new BeanHandler<>(User.class), user.getUsern(), user.getPasswd(), user.getType());
        }catch (Exception e){
            e.printStackTrace();
        }

        if(bean == null){
            return "failed";
        } else{
            return "success";
        }
    }

}
