package com.mybatispuls.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatispuls.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Qiu-Qingzhou
 * @since 2020-02-13
 */
public interface PersonMapper extends BaseMapper<Person> {

    IPage<Person> findPersonListByPage(Page page);
}
