package com.glitter.demo.dao;

import com.glitter.demo.bean.MemberInfo;

public interface MemberInfoMapper {

    int deleteByPrimaryKey(Long memberId);

    int insert(MemberInfo record);

    int insertSelective(MemberInfo record);

    MemberInfo selectByPrimaryKey(Long memberId);

    int updateByPrimaryKeySelective(MemberInfo record);

    int updateByPrimaryKey(MemberInfo record);

}