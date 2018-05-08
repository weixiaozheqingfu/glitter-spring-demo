package com.glitter.demo.service.impl;

import com.glitter.demo.bean.PositionGroup;
import com.glitter.demo.context.SqlSessionThreadLocal;
import com.glitter.demo.dao.PositionGroupMapper;
import com.glitter.demo.dao.impl.PositionGroupMapperImpl;
import com.glitter.demo.mybatis.MySqlSession;
import com.glitter.demo.service.IPositionGroupService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;

import java.sql.SQLException;

public class PositionGroupServiceImpl implements IPositionGroupService{

    // 自己的实现,里面直接通过session对象和方法名称字符串操作xml中对应的sql方法
    PositionGroupMapper positionGroupMapper1 = new PositionGroupMapperImpl();
    // 直接动态new一个PositionGroupMapper接口对应的xml实现类给接口
    PositionGroupMapper positionGroupMapper2;


    /**
     * 测试纯mybatis下事务的用法
     *
     * positionGroupMapper1是Spring注入的一个单例类
     *
     * 结合动态代理和ThreadLocal，我们就可以很容易模拟出spring的aop事务了。
     * 当然此处的代码没做动态代理。
     * @param record
     * @return
     */
    @Override
    public void create(PositionGroup record){
        Transaction transaction = null;
        try{
            // 获取session开启事务部分可以放在动态代理invoke方法在调用目标方法即create方法之前,spring其实就是这样干的
            SqlSessionThreadLocal.setSqlSession(MySqlSession.newSqlSession());
            transaction = new JdbcTransaction(SqlSessionThreadLocal.getSqlSession().getConnection());
            transaction.getConnection().setAutoCommit(false);
            // 模拟此处成功
            positionGroupMapper1.deleteByPrimaryKey(24L);

            // 模拟此处失败
            positionGroupMapper1.insertSelective(record);

            // 事务提交或者回滚，部分可以放在动态代理invoke方法在invoke方法在调用目标方法时,catch中是回滚，没有异常就提交
            transaction.commit();
        } catch (Exception e){
            try {
                transaction.rollback();
            } catch (SQLException e1) {

            }
        } finally {
            SqlSessionThreadLocal.getSqlSession().close();
        }
    }

    /**
     * 动态代理模拟spring的aop事务原理,spring的aop就是基于动态代理的,事务当然也是
     * @param record
     */
    @Override
    public void createProxy(PositionGroup record) {
        // 模拟此处成功
        positionGroupMapper1.deleteByPrimaryKey(25L);
        // 模拟此处失败
        positionGroupMapper1.insertSelective(record);
    }





































    /**
     * 方式一:通过直接调用的方式
     * @param positionGroupId
     * @return
     */
    @Override
    public PositionGroup findById(Long positionGroupId) {
        try {
            SqlSessionThreadLocal.setSqlSession(MySqlSession.newSqlSession());
            PositionGroup result1 = positionGroupMapper1.selectByPrimaryKey(positionGroupId);
            return result1;
        } finally {
            SqlSessionThreadLocal.getSqlSession().close();
        }
    }

    /**
     * 方式二:通过接口new对应的mapper.xml实现类的方式
     * // 使用这种方式有一个问题，我们想模拟spring把positionGroupMapper2认为是单例的,
     * // 这样的话，方法二中此处的positionGroupMapper2是全局单例且在不同方法中会与session相串,最终导致事务紊乱。
     *
     * // 但是spring的aop事务又是如何做到这一切呢，看上去，他也是基于单例的，这个问题值得后续继续研究。
     * // 有更多的问题需要研究，暂时先搁置此问题，不能一叶障目，就不见泰山，就停滞不前，那样将会永远裹足不前。
     * // 知道哪里会，哪里不会也是一种能力，暂时放一放也是一种智慧和勇气，人有时候不能太有完美和一次求成的执念，知足知不足，日后补足。
     *
     * @param positionGroupId
     * @return
     */
    @Override
    public PositionGroup findById2(Long positionGroupId) {
        SqlSession session = null;
        try {
            session = MySqlSession.newSqlSession();
            positionGroupMapper2 = session.getMapper(PositionGroupMapper.class);
            PositionGroup result2 = positionGroupMapper2.selectByPrimaryKey(positionGroupId);
            return result2;
        } finally {
            session.close();
        }
    }


}