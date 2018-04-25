package com.glitter.demo.dao;

import com.glitter.demo.bean.PositionMember;

public interface PositionMemberMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PositionMember record);

    int insertSelective(PositionMember record);

    PositionMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PositionMember record);

    int updateByPrimaryKey(PositionMember record);

}