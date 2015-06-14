package com.licong.repository.dao;

/**
 * Created by lctm2005 on 2014/6/19.
 */

import com.licong.repository.domain.GlobalConfig;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.DEFAULT)
@ContextConfiguration(locations = "classpath:spring4mvc-test.xml")
@Transactional
public class GlobalConfigDaoTest {

    @Autowired
    private GlobalConfigDao globalConfigDao;

    @Test
    public void testSave() {
        GlobalConfig expect = new GlobalConfig();
        expect.setItemKey("Test");
        expect.setItemValue("Value");
        expect = globalConfigDao.save(expect);
        Assert.assertNotNull(expect.getId());
    }

    @Test
    public void testFindOne() {
        GlobalConfig expect = new GlobalConfig();
        expect.setItemKey("Test");
        expect.setItemValue("Value");
        expect = globalConfigDao.save(expect);
        GlobalConfig actual = globalConfigDao.findOne(expect.getId());
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testFindByItemKey() {
        GlobalConfig expect = new GlobalConfig();
        expect.setItemKey("Test");
        expect.setItemValue("Value");
        expect = globalConfigDao.save(expect);
        GlobalConfig actual = globalConfigDao.findByItemKey(expect.getItemKey());
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testFindByItemValue() {
        GlobalConfig expect = new GlobalConfig();
        expect.setItemKey("Test");
        expect.setItemValue("Value");
        expect = globalConfigDao.save(expect);
        GlobalConfig actual = globalConfigDao.findByItemValue(expect.getItemValue());
        Assert.assertEquals(expect, actual);
    }


    @Test
    public void testDelete() {
        GlobalConfig expect = new GlobalConfig();
        expect.setItemKey("Test");
        expect.setItemValue("a");
        expect = globalConfigDao.save(expect);
        globalConfigDao.delete(expect.getId());
        Assert.assertNull(globalConfigDao.findOne(expect.getId()));
    }


    @Test
    public void testFindByItemValueByPage() {
        // 分页的一般需求
        // 上一页
        // 下一页
        // 第一页
        // 最后一页
        // 第N页
        // 总条数
        // 总页数

        String itemKey = "Test";

        // 制造数据,22条
        for(int i=0; i<22; i++) {
            GlobalConfig expect = new GlobalConfig();
            expect.setItemKey(itemKey);
            expect.setItemValue(String.valueOf(i));
            expect = globalConfigDao.save(expect);
        }
        // 第N页
        Page<GlobalConfig> page = globalConfigDao.findByItemKey(itemKey, new PageRequest(1,10));

        System.out.println("TotalPages:" + page.getTotalPages());
        System.out.println("TotalElements:" + page.getTotalElements());
        System.out.println("size:" + page.getSize());
        System.out.println("number:" + page.getNumber());
        System.out.println("hasNext:" + page.hasNext());
        System.out.println("isFirst:" + page.isFirst());
        System.out.println("isLast:" + page.isLast());
        System.out.println("hasPrevious:" + page.hasPrevious());
        System.out.println("content:");
        List<GlobalConfig> content = page.getContent();
        for(GlobalConfig globalConfig : content) {
            System.out.println(globalConfig.toString());
        }
    }


}
