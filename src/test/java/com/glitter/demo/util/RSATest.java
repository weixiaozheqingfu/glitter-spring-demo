package com.glitter.demo.util;


import com.glitter.demo.dao2.PositionGroupDao;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2018/4/17.
 */
public class RSATest {

    @Test
    public void testA(){
        System.out.println("Hello World");
        Assert.assertEquals("1","1");

        PositionGroupDao positionGroupDao = new PositionGroupDao();
        positionGroupDao.selectByPrimaryKey(25L);
    }
}
