package com.anmi.mapper;

import com.anmi.base.BaseSqlBuilder;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjue on 2017/7/19.
 */
public interface BaseMapper<T> {

    @SelectProvider(type = BaseSqlBuilder.class, method = "getAllSql")
    List<T> getAll(Class<?> type);

    @SelectProvider(type = BaseSqlBuilder.class, method = "getByPropertiesSql")
    List<T> getByProperties(Class<?> type,Map<String,Object> properties);

}
