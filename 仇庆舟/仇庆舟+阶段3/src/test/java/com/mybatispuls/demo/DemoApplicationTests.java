package com.mybatispuls.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatispuls.dao.PersonMapper;
import com.mybatispuls.entity.Person;
import com.mybatispuls.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Resource
    private PersonService personService;
    @Resource
    private PersonMapper personMapper;
    //增加一个用户
    @Test
    public void add(){
        Person person = new Person();
        person.setAge(15);

        person.setName("小东");
        System.out.println(personService.save(person));
    }

    //删除id为6的用户
    @Test
    public void delete(){
        System.out.println(personService.removeById(6));
    }

    //更改id为1一个用户
    @Test
    public void update(){
        Person person = new Person();
        person.setAge(15);
        person.setId(1);
        person.setName("小飞");
        System.out.println(personService.updateById(person));
    }

    //查看所有用户
    @Test
    public void showall() {

        List<Person> list = personService.list();
        for(Person person : list){
            System.out.println(person);
        }
    }

    //条件查询,查询id为1的用户
    @Test
    public void condition(){
        QueryWrapper<Person> wp = new QueryWrapper<>();
        wp.eq("id",1);
        System.out.println(personService.getOne(wp));
    }

    //分页查询
    @Test
    public void page(){
        Page<Person> page = new Page<>(1,2);
        IPage<Person> pagePerson = personMapper.findPersonListByPage(page);
        System.out.println("当前页码："+pagePerson.getCurrent());
        System.out.println("每页显示数量："+pagePerson.getSize());
        System.out.println("总页数："+pagePerson.getPages());
        System.out.println("总记录数："+pagePerson.getTotal());
        for (Person person : pagePerson.getRecords()){
            System.out.println(person);
        }


    }
}
