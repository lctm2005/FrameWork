package com.licong.service.impl;

import com.licong.repository.dao.GlobalConfigDao;
import com.licong.repository.domain.GlobalConfig;
import com.licong.service.IGlobalConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by lctm2005 on 2014/7/23.
 */
@Service
public class GlobalConfigService implements IGlobalConfigService {

    @Autowired
    private GlobalConfigDao globalConfigDao;

    @Override
    public GlobalConfig get(Long id) {
        Assert.notNull(id, "id should not be null");
        return globalConfigDao.findOne(id);
    }
}
