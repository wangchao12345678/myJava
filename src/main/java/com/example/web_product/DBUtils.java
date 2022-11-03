package com.example.web_product;


import com.mysql.jdbc.Driver;
import lombok.var;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {//获取链接对象
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1?useUnicode=true&characterEncoding=utf-8", "root", "telephone");
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
        return connection;
    }
    public static int executeCUD(String sql)  {//增删改
        Connection connection=getConnection();
        try {
            Statement statement=connection.createStatement();
            int n=statement.executeUpdate(sql);
            statement.close();
            connection.close();
            return n;
        }catch (Exception e){
            throw new RuntimeException("增删改异常");
        }
    }
    public static <T> List<T> executeR(String sql, Class<T> tClass) {//查询
        List<T> list = new ArrayList();
        T t = null;//定义对象
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
         ResultSet resultSet=statement.executeQuery(sql);
         while (resultSet.next()){
            t=tClass.newInstance();//反射对象
             Field[] fields = tClass.getDeclaredFields();//反射属性
             for (Field field: fields){
                 field.setAccessible(true);//设置属性可见
               field.set(t,resultSet.getObject(field.getName()));
             }
             list.add(t);
         }

        } catch (SQLException e) {
            System.out.printf( e.getMessage());
        } catch (Exception e){
            System.out.printf( e.getMessage());
        }
        return list;
    }
}
