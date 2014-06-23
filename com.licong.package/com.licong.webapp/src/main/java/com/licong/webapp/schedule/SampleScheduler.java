package com.licong.webapp.schedule;

import com.licong.webapp.dao.GlobalConfig;
import com.licong.webapp.dao.GlobalConfigDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by lctm2005 on 2014/5/31.
 */
@Configuration
@EnableAsync
@EnableScheduling
public class SampleScheduler {

    private static final Logger LOG = LoggerFactory.getLogger(SampleScheduler.class);

    @Autowired
    private GlobalConfigDao globalConfigDao;

    // 每小时
    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void run() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setItemKey("Test");
        globalConfig.setItemValue("Value");
        globalConfigDao.save(globalConfig);
//        globalConfigDao.delete(globalConfig);
    }

}
