package com.licong.webapp;

/**
 * Created by lctm2005 on 2014/6/19.
 */

import com.licong.util.Assert;
import com.licong.webapp.dao.GlobalConfig;
import com.licong.webapp.dao.GlobalConfigDao;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.DEFAULT)
@ContextConfiguration(locations= "/spring4mvc-test.xml")
public class GlobalConfigDaoTest {

    @Autowired
    private GlobalConfigDao globalConfigDao;

    private GlobalConfig expect;

    @Before
    public void before() {
        expect = new GlobalConfig();
        expect.setItemKey("Test");
        expect.setItemValue("Value");
        expect.setId(108L);
    }

    @Test
    @Transactional
    public void testSave() {
        GlobalConfig expect = new GlobalConfig();
        expect.setItemKey("Test1");
        expect.setItemValue("Value1");
        expect = globalConfigDao.save(expect);
        Assert.assertNotNull(expect.getId());
    }

    @Test
    public void testFindOne() {
        GlobalConfig actual =  globalConfigDao.findOne(expect.getId());
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testFindByItemKey() {
        GlobalConfig actual = globalConfigDao.findByItemKey(expect.getItemKey());
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testFindByItemValue() {
        GlobalConfig actual = globalConfigDao.findByItemValue(expect.getItemValue());
        Assert.assertEquals(expect, actual);
    }


    @Test
    public void testDelete() {
        globalConfigDao.delete(expect.getId());
        Assert.assertNull(globalConfigDao.findOne(expect.getId()));
    }

}
