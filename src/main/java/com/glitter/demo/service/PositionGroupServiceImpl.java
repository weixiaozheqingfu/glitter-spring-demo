package com.glitter.demo.service;

import com.glitter.demo.bean.PositionGroup;
import com.glitter.demo.dao.PositionGroupMapper;
import com.glitter.demo.mybatis.MySqlSession;
import org.apache.ibatis.session.SqlSession;

public class PositionGroupServiceImpl implements IPositionGroupService{

    private static final String namespace = "com.glitter.demo.dao.PositionGroupMapper";

    SqlSession session = MySqlSession.newSqlSession();
    PositionGroupMapper mapper = session.getMapper(PositionGroupMapper.class);


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
            PositionGroup result = session.selectOne(namespace+".selectByPrimaryKey",positionGroupId);
            return result;
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
            PositionGroup result1 = mapper.selectByPrimaryKey(positionGroupId);
            return result1;
        } finally {
            session.close();
        }
    }


}