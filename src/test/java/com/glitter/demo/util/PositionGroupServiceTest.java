package com.glitter.demo.util;


import com.glitter.demo.bean.PositionGroup;
import com.glitter.demo.service.IPositionGroupService;
import com.glitter.demo.service.PositionGroupServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/4/17.
 */
public class PositionGroupServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(PositionGroupServiceTest.class);

    @Test
    public void testFindById(){
        System.out.println("Hello World");
        Assert.assertEquals("1","1");

        IPositionGroupService positionGroupService = new PositionGroupServiceImpl();
        PositionGroup result = positionGroupService.findById(25L);
        logger.info("result结果："+result);
    }
}
