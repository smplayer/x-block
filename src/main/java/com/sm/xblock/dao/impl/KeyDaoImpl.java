package com.sm.xblock.dao.impl;

import com.sm.common.dao.impl.HibernateGenericDaoImpl;
import com.sm.xblock.dao.KeyDao;
import com.sm.xblock.entity.Key;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by smplayer on 2016/5/4.
 */
@Repository("keyDao")
public class KeyDaoImpl extends HibernateGenericDaoImpl<Key, String> implements KeyDao {

    private Connection conn = null;
    private PreparedStatement pstm = null;

    public KeyDaoImpl() {
        super();
        String url = "jdbc:mysql://localhost:3306/x-block" ;
        String username = "root" ;
        String password = "root" ;
        try{
            //加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver") ;
            conn = DriverManager.getConnection(url , username , password );
            pstm = conn.prepareStatement("INSERT INTO sm_tb_key VALUES(?, ?, null, null, ?)");

        }catch(ClassNotFoundException e){
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace() ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveKeys(List<String> keys) {

        try {
            conn.setAutoCommit(false);
            for(String key : keys) {
                pstm.setString(1, UUID.randomUUID().toString().replaceAll("-",""));
                pstm.setLong(2, new Date().getTime());
                pstm.setString(3, key);
                pstm.addBatch();
            }
            pstm.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }

}
