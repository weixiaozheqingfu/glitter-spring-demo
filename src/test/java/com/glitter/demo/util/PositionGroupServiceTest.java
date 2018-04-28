package com.glitter.demo.util;


import com.glitter.demo.bean.PositionGroup;
import com.glitter.demo.proxy.TransactionalProxy;
import com.glitter.demo.service.IPositionGroupService;
import com.glitter.demo.service.impl.PositionGroupServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/17.
 */
public class PositionGroupServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(PositionGroupServiceTest.class);

    IPositionGroupService positionGroupService = new PositionGroupServiceImpl();

    IPositionGroupService positionGroupServiceProxy = (IPositionGroupService) Proxy.newProxyInstance(
            IPositionGroupService.class.getClassLoader(),
            PositionGroupServiceImpl.class.getInterfaces(),
            new TransactionalProxy(PositionGroupServiceImpl.class.newInstance())
    );

    public PositionGroupServiceTest() throws IllegalAccessException, InstantiationException {
    }

    @Test
    public void testCreate() throws SQLException {
        Long orgId = 1L;

        Date now = new Date();
        PositionGroup record = new PositionGroup();
        record.setCreateTime(now);
        record.setDeleteFlag(new Byte("1"));
        record.setOrgId(1L);
        record.setUpdateTime(now);
        record.setGroupName("测试分组1");
        // 故意制造主键冲突
        record.setPositionGroupId(48L);

        positionGroupService.create(record);
    }


    @Test
    public void testCreateProxy() throws SQLException {
        Long orgId = 1L;

        Date now = new Date();
        PositionGroup record = new PositionGroup();
        record.setCreateTime(now);
        record.setDeleteFlag(new Byte("1"));
        record.setOrgId(1L);
        record.setUpdateTime(now);
        record.setGroupName("测试分组1");
        // 故意制造主键冲突
//        record.setPositionGroupId(48L);

        positionGroupServiceProxy.createProxy(record);
    }



    @Test
    public void testFindById(){
        System.out.println("Hello World");
        Assert.assertEquals("1","1");

        PositionGroup result = positionGroupService.findById(25L);
        logger.info("result结果："+result);
    }

    @Test
    public void testFindById2(){
        PositionGroup result = positionGroupService.findById2(25L);
        logger.info("result结果："+result);
    }
}
