package com.glitter.demo.service.impl;

import com.glitter.demo.bean.PositionGroup;
import com.glitter.demo.dao.PositionGroupMapper;
import com.glitter.demo.dao.impl.PositionGroupMapperImpl;
import com.glitter.demo.mybatis.MySqlSession;
import com.glitter.demo.service.IPositionGroupService;
import org.apache.ibatis.session.SqlSession;

public class PositionGroupServiceImpl implements IPositionGroupService{

    // 自己的实现,里面直接通过session对象和方法名称字符串操作xml中对应的sql方法
    PositionGroupMapper positionGroupMapper1;
    // 直接动态new一个PositionGroupMapper接口对应的xml实现类给接口
    PositionGroupMapper positionGroupMapper2;

    /**
     * 测试纯mybatis下事务的用法
     * @param record
     * @return
     */
    @Override
    public int create(PositionGroup record) {
        // 1.删除用户成功
//        Transaction transaction = new JdbcTransaction(session.getConnection());
//        transaction.commit();
        // 2.新增用户失败
        return 0;
    }

    /**
     * 方式一:通过直接调用的方式
     * @param positionGroupId
     * @return
     */
    @Override
    public PositionGroup findById(Long positionGroupId) {
        SqlSession session = null;
        try {
            session = MySqlSession.newSqlSession();
            positionGroupMapper1 = new PositionGroupMapperImpl(session);
            PositionGroup result1 = positionGroupMapper1.selectByPrimaryKey(positionGroupId);
            return result1;
        } finally {
            session.close();
        }
    }

    /**
     * 方式二:通过接口new对应的mapper.xml实现类的方式
     * // TODO 这里留一个问题，即如果该实现类是单例的情况下，高并发时，有两个用户同时调用该实例的两个不同的方法，如何保证session不串。
     * // 即第一个方法刚获取到一个session1，然后基于session1得到了mapper对象，但是方法没往下继续走，此时线程切换到另外一个方法，session又重新获取成了session2，那么
     * // 此时线程切换到第一个方法，那么第一个方法是不是就变成使用session2了，此时方法一执行session.close的时候，会不会将方法二中的session也关闭了，因为是同一个对象啊。
     * // 更可怕的是事务问题，事务开启和事务提交及事务回滚，都是基于connection对象的，也就是基于mybatis封装的session对象的，如果session在一个方法执行过程中被重新赋值，
     * // 那么当这个方法执行事务开启和事务提交或者事务回滚使不是基于同一个session，事务就会有问题。
     * // 但是spring的aop又是如何做到这一切呢，看上去，他也是基于单例的，这个问题值得后续继续研究。有更多的问题需要研究，暂时先搁置此问题，不能一叶障目，就停滞不前，那样将会永远裹足不前。
     * // 知道哪里会，哪里不会也是一种能力，暂时放一放也是一种智慧。
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