package com.licong.service;

import com.licong.repository.domain.GlobalConfig;

/**
 * Created by lctm2005 on 2014/7/23.
 */
public interface IGlobalConfigService {
    /**
     * 根据ID查询GlobalConfig
     * @param id
     * @return
     */
    public GlobalConfig get(Long id);
}
