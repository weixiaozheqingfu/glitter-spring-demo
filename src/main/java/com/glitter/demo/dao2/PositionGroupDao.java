package com.glitter.demo.dao2;

import com.glitter.demo.bean.PositionGroup;
import com.glitter.demo.mybatis.SqlSession;

public class PositionGroupDao {
    private static final String namespace = "com.glitter.demo.dao.PositionGroupMapper";

//    int deleteByPrimaryKey(Long positionGroupId);
//
//    int insert(PositionGroup record);
//
//    int insertSelective(PositionGroup record);

    public PositionGroup selectByPrimaryKey(Long positionGroupId){
        org.apache.ibatis.session.SqlSession session = SqlSession.newSqlSession();
        try {
            PositionGroup result = session.selectOne(namespace+".selectByPrimaryKey",positionGroupId);
            return result;
        } finally {
            session.close();
        }
    }


//    int updateByPrimaryKeySelective(PositionGroup record);
//
//    int updateByPrimaryKey(PositionGroup record);

}