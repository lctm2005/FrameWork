package com.licong.repository.dao;

import com.licong.repository.domain.GlobalConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by lctm2005 on 2014/6/18.
 */
public interface GlobalConfigDao extends PagingAndSortingRepository<GlobalConfig, Long> {

    /**
     * 根据方法名称查询
     * @param itemKey
     * @return
     */
    public GlobalConfig findByItemKey(String itemKey);

    /**
     * 根据注解查询
     * @param itemValue
     * @return
     */
    @Query("from GlobalConfig c where c.itemValue = :itemValue")
    public GlobalConfig findByItemValue(@Param("itemValue") String itemValue);

    /**
     *  根据注解分页查询
     * @param itemKey
     * @param pageable
     * @return
     */
    @Query("select a from GlobalConfig a where a.itemKey = :itemKey")
    public Page<GlobalConfig> findByItemKey(@Param("itemKey") String itemKey, Pageable pageable);
}
