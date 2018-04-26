package com.glitter.demo.service.impl;

import com.glitter.demo.bean.PositionGroup;
import com.glitter.demo.dao.PositionGroupMapper;
import com.glitter.demo.dao.impl.PositionGroupMapperImpl;
import com.glitter.demo.mybatis.MySqlSession;
import com.glitter.demo.service.IPositionGroupService;
import org.apache.ibatis.session.SqlSession;

public class PositionGroupServiceImpl implements IPositionGroupService{
    SqlSession session = MySqlSession.newSqlSession();

    // 自己的实现,里面直接通过session对象和方法名称字符串操作xml中对应的sql方法
    PositionGroupMapper PositionGroupMapper1 = new PositionGroupMapperImpl();
    // 直接动态new一个PositionGroupMapper接口对应的xml实现类给接口
    PositionGroupMapper PositionGroupMapper2 = session.getMapper(PositionGroupMapper.class);

    /**
     * 测试纯mybatis下事务的用法
     * @param record
     * @return
     */
    @Override
    public int create(PositionGroup record) {
        return 0;
    }

    /**
     * 方式一:通过直接调用的方式
     * @param positionGroupId
     * @return
     */
    @Override
    public PositionGroup findById(Long positionGroupId) {
        try {
            PositionGroup result1 = PositionGroupMapper1.selectByPrimaryKey(positionGroupId);
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
        try {
            PositionGroup result2 = PositionGroupMapper2.selectByPrimaryKey(positionGroupId);
            return result2;
        } finally {
            session.close();
        }
    }


}