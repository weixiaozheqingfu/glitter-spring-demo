package com.glitter.demo.dao;

import com.glitter.demo.bean.PositionInfo;

public interface PositionInfoMapper {

    int deleteByPrimaryKey(Long positionId);

    int insert(PositionInfo record);

    int insertSelective(PositionInfo record);

    PositionInfo selectByPrimaryKey(Long positionId);

    int updateByPrimaryKeySelective(PositionInfo record);

    int updateByPrimaryKey(PositionInfo record);

}