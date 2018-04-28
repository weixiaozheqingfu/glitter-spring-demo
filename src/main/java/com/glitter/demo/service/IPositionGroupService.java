package com.glitter.demo.service;

import com.glitter.demo.bean.PositionGroup;

import java.sql.SQLException;

/**
 * @author admin
 */
public interface IPositionGroupService {

    void create(PositionGroup record) throws SQLException;

    PositionGroup findById(Long positionGroupId);

    PositionGroup findById2(Long positionGroupId);

}