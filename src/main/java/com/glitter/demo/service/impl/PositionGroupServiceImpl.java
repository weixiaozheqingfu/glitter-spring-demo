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