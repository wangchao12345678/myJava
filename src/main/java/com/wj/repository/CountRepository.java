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
    public static SqlSession getSqlSession(){//��̬��������sql�Ự
        SqlSession sqlSession=null;
        try {
            InputStream inputStream=Resources.getResourceAsStream("MysqlConfig/Mysql.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
            sqlSession=sqlSessionFactory.openSession(true);//�ؼ��㣬mybatisĬ�ϲ����Զ��ύ�����, ������ʵû���޸����ݿ⣬������sqlsession.commit()�����ύ����
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlSession;
    }
}
