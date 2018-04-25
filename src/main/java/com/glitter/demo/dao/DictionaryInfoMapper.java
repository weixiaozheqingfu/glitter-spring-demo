package com.glitter.demo.dao;

import com.glitter.demo.bean.DictionaryInfo;

public interface DictionaryInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DictionaryInfo record);

    int insertSelective(DictionaryInfo record);

    DictionaryInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DictionaryInfo record);

    int updateByPrimaryKey(DictionaryInfo record);

}