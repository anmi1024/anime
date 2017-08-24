package com.anmi.mapper;

import com.anmi.base.BaseSqlBuilder;
import com.anmi.model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by wangjue on 2017/7/19.
 */
public interface UserMapper extends BaseMapper<User>{

    @Results(id = "userResult", value = {
        @Result(property = "pkId", column = "PK_ID")
    })
    @SelectProvider(type = BaseSqlBuilder.class, method = "getAllSql")
    @Override
    List<User> getAll(Class<?> type);

}
