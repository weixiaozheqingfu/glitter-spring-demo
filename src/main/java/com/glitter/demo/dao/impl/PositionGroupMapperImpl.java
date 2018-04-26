package com.glitter.demo.dao.impl;

import com.glitter.demo.bean.PositionGroup;
import com.glitter.demo.dao.PositionGroupMapper;
import org.apache.ibatis.session.SqlSession;

public class PositionGroupMapperImpl implements PositionGroupMapper{

    private static final String namespace = "com.glitter.demo.dao.PositionGroupMapper";

    SqlSession session;
    public PositionGroupMapperImpl(SqlSession session){
        this.session = session;
    }

    @Override
    public int deleteByPrimaryKey(Long positionGroupId) {
        return session.delete(namespace+".deleteByPrimaryKey",positionGroupId);
    }

    @Override
    public int insert(PositionGroup record) {
        return session.insert(namespace+".insert",record);
    }

    @Override
    public int insertSelective(PositionGroup record) {
        return session.insert(namespace+".insertSelective",record);
    }

    @Override
    public PositionGroup selectByPrimaryKey(Long positionGroupId) {
        return session.selectOne(namespace+".selectByPrimaryKey",positionGroupId);
    }

    @Override
    public int updateByPrimaryKeySelective(PositionGroup record) {
        return session.update(namespace+".updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(PositionGroup record) {
        return session.update(namespace+".updateByPrimaryKey",record);
    }

}