package com.glitter.demo.dao;

import com.glitter.demo.bean.PositionGroup;

public interface PositionGroupMapper {

    int deleteByPrimaryKey(Long positionGroupId);

    int insert(PositionGroup record);

    int insertSelective(PositionGroup record);

    PositionGroup selectByPrimaryKey(Long positionGroupId);

    int updateByPrimaryKeySelective(PositionGroup record);

    int updateByPrimaryKey(PositionGroup record);

}