package com.glitter.demo.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MySqlSession {
    private static String mybatisResource = "mybatis-config.xml";

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() {
        try {
            if (sqlSessionFactory == null) {
                InputStream inputStream = Resources.getResourceAsStream(mybatisResource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
            return sqlSessionFactory;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static org.apache.ibatis.session.SqlSession newSqlSession() {
        org.apache.ibatis.session.SqlSession session = getSqlSessionFactory().openSession();
        return session;
    }
}