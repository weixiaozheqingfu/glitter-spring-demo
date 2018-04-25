package com.glitter.demo.dao;

import com.glitter.demo.bean.DeptInfo;

public interface DeptInfoMapper {

    int deleteByPrimaryKey(Long deptId);

    int insert(DeptInfo record);

    int insertSelective(DeptInfo record);

    DeptInfo selectByPrimaryKey(Long deptId);

    int updateByPrimaryKeySelective(DeptInfo record);

    int updateByPrimaryKey(DeptInfo record);

}