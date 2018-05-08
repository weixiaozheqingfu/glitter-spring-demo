package com.glitter.demo.proxy;

import com.glitter.demo.context.SqlSessionThreadLocal;
import com.glitter.demo.mybatis.MySqlSession;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author limengjun
 */
public class TransactionalProxy implements InvocationHandler {


    private Object subject;

    public TransactionalProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = null;
        Transaction transaction = null;
        try{
            // 获取session开启事务部分可以放在动态代理invoke方法在调用目标方法即create方法之前,spring其实就是这样干的
            SqlSession sqlSession = MySqlSession.newSqlSession();
            SqlSessionThreadLocal.setSqlSession(sqlSession);
            transaction = new JdbcTransaction(sqlSession.getConnection());
            transaction.getConnection().setAutoCommit(false);
            // 目标对象方法调用
            returnValue = method.invoke(subject, args);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }finally {
            // 这行代码不能放开,否则报错,不知道什么原因,给人的感觉是会先执行这行代码,连接被提前关闭了
//            SqlSessionThreadLocal.getSqlSession().getConnection().close();
        }
        return returnValue;
    }

}

