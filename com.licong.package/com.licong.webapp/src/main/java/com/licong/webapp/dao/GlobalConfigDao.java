package com.licong.webapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by lctm2005 on 2014/6/18.
 */
public interface GlobalConfigDao extends CrudRepository<GlobalConfig, Long> {

    public GlobalConfig findByItemKey(String itemKey);

    @Query("from GlobalConfig c where c.itemValue = :itemValue")
    public GlobalConfig findByItemValue(@Param("itemValue")String itemValue);


    @Query("select a from GlobalConfig a where a.itemValue = :itemValue")
    public Page<GlobalConfig> findByItemValue(@Param("itemValue")String itemValue,Pageable pageable);
}
