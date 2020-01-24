package com.yuchen.generator.mapper;

import com.yuchen.generator.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author YuChen
 * @since 2020-01-22
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where username = #{name}")
    List<User> selectByName(@Param("name") String name);
}
