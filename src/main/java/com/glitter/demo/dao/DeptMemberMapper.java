package com.glitter.demo.dao;

import com.glitter.demo.bean.DeptMember;

public interface DeptMemberMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DeptMember record);

    int insertSelective(DeptMember record);

    DeptMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeptMember record);

    int updateByPrimaryKey(DeptMember record);

}