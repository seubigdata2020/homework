package com.homework.stage_2.controller;

import com.homework.stage_2.jpa.Fruit;
import com.homework.stage_2.myjdbc.MyJDBC;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FruitJDBCController {


    /**
     * 查找所有的水果信息
     * @return
     */
    @RequestMapping(value="/jdbc_findAllFruit")
    public List<Fruit> findAll() throws Exception {
        MyJDBC mj = new MyJDBC();
        List<Fruit> list = mj.listFruit();
        return list ;
    }

    /**
     * 根据输入的水果名称查出一条对应信息
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jdbc_findOne")
    public Fruit findOne(@RequestParam String name) throws Exception {
        MyJDBC mj = new MyJDBC();
        Fruit fruit = mj.findByName(name);
        return fruit;
    }

    /**
     * 修改一条水果信息
     * @param price
     * @return
     */
    @RequestMapping(value="/jdbc_updataOne")
    public boolean updata( int id,String name,double price,String address) throws Exception {
        MyJDBC mj = new MyJDBC();
        boolean flag=mj.updateFruit(id,name,price,address);
        return flag;
    }

    /**
     * 增加一条水果信息
     * @param name
     * @param price
     * @param address
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jdbc_addOne")
    public Fruit addOne(String name,double price,String address) throws Exception{
        MyJDBC mj = new MyJDBC();
        Fruit fruit = mj.addOne(name,price,address);
        mj.CloseConnect();
        return fruit;
    }

    @RequestMapping(value = "/jdbc_deleteOne")
    public boolean deleteOne(String name)throws Exception{
        MyJDBC mj = new MyJDBC();
        boolean flag = mj.deleteOne(name);
        mj.CloseConnect();
        return flag;
    }

}
