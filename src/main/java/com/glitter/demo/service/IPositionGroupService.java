package com.glitter.demo.service;

import com.glitter.demo.bean.PositionGroup;

/**
 * @author admin
 */
public interface IPositionGroupService {

    int create(PositionGroup record);

    PositionGroup findById(Long positionGroupId);

    PositionGroup findById2(Long positionGroupId);

}