package com.mybatispuls.service.impl;

import com.mybatispuls.entity.Person;
import com.mybatispuls.dao.PersonMapper;
import com.mybatispuls.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Qiu-Qingzhou
 * @since 2020-02-13
 */
@Service
public  class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}
