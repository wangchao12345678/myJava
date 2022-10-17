package com.wj.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
@Repository(value = "countRepository")
public class CountRepository {
    public static SqlSession getSqlSession(){//静态方法返回sql会话
        SqlSession sqlSession=null;
        try {
            InputStream inputStream=Resources.getResourceAsStream("MysqlConfig/Mysql.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
            sqlSession=sqlSessionFactory.openSession(true);//关键点，mybatis默认不是自动提交事务的, 所以其实没有修改数据库，或者用sqlsession.commit()方法提交事务
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlSession;
    }
}
