package com.licong.webapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
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
     * 根据方法名分页查询
     * @param pageable
     * @return
     */
    public Page<GlobalConfig> findByItemValue(String itemValue, Pageable pageable, Sort sort);

    /**
     * 根据注解查询
     * @param itemValue
     * @return
     */
    @Query("select a from GlobalConfig c where c.itemValue = :itemValue")
    public GlobalConfig findByItemValue(@Param("itemValue")String itemValue);

    /**
     *  根据注解分页查询
     * @param itemValue
     * @param pageable
     * @return
     */
    @Query("select a from GlobalConfig a where a.itemValue = :itemValue")
    public Page<GlobalConfig> findByItemValue(@Param("itemValue")String itemValue, Pageable pageable);


    @Modifying
    @Query("update AccountInfo a set a.salary = ?1 where a.salary < ?2")
    public int increaseSalary(int after, int before);



}
