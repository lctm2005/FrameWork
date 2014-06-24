package com.licong.webapp;

/**
 * Created by lctm2005 on 2014/6/19.
 */

import ch.qos.logback.core.net.SyslogOutputStream;
import com.licong.util.Assert;
import com.licong.webapp.dao.GlobalConfig;
import com.licong.webapp.dao.GlobalConfigDao;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

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

    @Test
    public void testFindByItemValueByPage() {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "itemKey"));
        Page<GlobalConfig> page = globalConfigDao.findByItemValue(new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 1;
            }

            @Override
            public int getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        },sort);

        System.out.println("总页数:" + page.getTotalPages());
        System.out.println("总条数:" + page.getTotalElements());
        System.out.println("size:" + page.getSize());
        Iterator<GlobalConfig> iterator = page.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }


}
