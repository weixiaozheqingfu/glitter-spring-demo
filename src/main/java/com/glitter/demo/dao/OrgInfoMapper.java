package com.glitter.demo.dao;

import com.glitter.demo.bean.OrgInfo;

public interface OrgInfoMapper {

    int deleteByPrimaryKey(Long orgId);

    int insert(OrgInfo record);

    int insertSelective(OrgInfo record);

    OrgInfo selectByPrimaryKey(Long orgId);

    int updateByPrimaryKeySelective(OrgInfo record);

    int updateByPrimaryKey(OrgInfo record);

}