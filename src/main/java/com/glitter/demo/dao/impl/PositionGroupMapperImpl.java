package com.glitter.demo.dao.impl;

import com.glitter.demo.bean.PositionGroup;
import com.glitter.demo.context.SqlSessionThreadLocal;
import com.glitter.demo.dao.PositionGroupMapper;
import org.apache.ibatis.session.SqlSession;

public class PositionGroupMapperImpl implements PositionGroupMapper{

    private static final String namespace = "com.glitter.demo.dao.PositionGroupMapper";


    @Override
    public int deleteByPrimaryKey(Long positionGroupId) {
        SqlSession sqlSession = SqlSessionThreadLocal.getSqlSession();
        return sqlSession.delete(namespace+".deleteByPrimaryKey",positionGroupId);
    }

    @Override
    public int insert(PositionGroup record) {
        SqlSession sqlSession = SqlSessionThreadLocal.getSqlSession();
        return sqlSession.insert(namespace+".insert",record);
    }

    @Override
    public int insertSelective(PositionGroup record) {
        SqlSession sqlSession = SqlSessionThreadLocal.getSqlSession();
        return sqlSession.insert(namespace+".insertSelective",record);
    }

    @Override
    public PositionGroup selectByPrimaryKey(Long positionGroupId) {
        SqlSession sqlSession = SqlSessionThreadLocal.getSqlSession();
        return sqlSession.selectOne(namespace+".selectByPrimaryKey",positionGroupId);
    }

    @Override
    public int updateByPrimaryKeySelective(PositionGroup record) {
        SqlSession sqlSession = SqlSessionThreadLocal.getSqlSession();
        return sqlSession.update(namespace+".updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(PositionGroup record) {
        SqlSession sqlSession = SqlSessionThreadLocal.getSqlSession();
        return sqlSession.update(namespace+".updateByPrimaryKey",record);
    }

}