package com.homework.stage_2.controller;

import com.homework.stage_2.jpa.Fruit;
import com.homework.stage_2.jpa.FruitRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class FruitController{
    @Autowired
    private FruitRepos fruitRepos;

    /**
     * 查找所有的水果信息
     * @return
     */
    @RequestMapping(value="/findAllFruit")
    public List<Fruit> findAll(){
        return fruitRepos.findAll();
    }


    /**
     * 根据水果id查找一条水果信息，包括价格，生产场地
     */
    @RequestMapping(value="/findFruitByName")
    public Fruit findFruitByName(Integer id){
        return fruitRepos.findById(id).get();
    }


    /**
     * 更新一条水果信息，包括价格，生产场地
     */
    @RequestMapping(value="/updataFruit")
    public Fruit updataFruit(@RequestParam Integer id,
                             @RequestParam String fruit_name,
                             @RequestParam double price,
                             @RequestParam String address
                             )
    {
        Fruit fruit = new Fruit();
        fruit.setId(id);
        fruit.setFruit_name(fruit_name);
        fruit.setPrice(price);
        fruit.setAddress(address);
        return fruitRepos.save(fruit);
    }


    /**
     *根据水果id增加一条水果信息，包括价格，生产场地
     */
    @RequestMapping(value="/addFruit")
    public Fruit addFruitt(
            @RequestParam String fruit_name,
            @RequestParam double price,
            @RequestParam String address
    )
    {
        Fruit fruit = new Fruit();
        fruit.setFruit_name(fruit_name);
        fruit.setPrice(price);
        fruit.setAddress(address);
        return fruitRepos.save(fruit);
    }



    /**
     *根据水果id删除一条水果信息，包括价格，生产场地
     */
    @RequestMapping(value="/deleteFruit")
    public boolean deleteFruit(Integer id){
        try{
            fruitRepos.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }




}