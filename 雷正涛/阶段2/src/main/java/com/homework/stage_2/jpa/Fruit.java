package com.homework.stage_2.jpa;


import javax.persistence.*;
import java.io.Serializable;

@Table(name="fruit")
@Entity
public class Fruit implements Serializable {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 水果名称.
     */
    @Column(name = "fruit_name")//对应字段名
    private String fruit_name = "";

    /**
     * 价格.
     */
    @Column(name = "price")//对应字段名
    private double price=0.0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFruit_name() {
        return fruit_name;
    }

    public void setFruit_name(String fruit_name) {
        this.fruit_name = fruit_name;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id='" + id + '\'' +
                ", fruit_name='" + fruit_name + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 产地.
     */
    @Column(name = "address")//对应字段名
    private String address = "";




}
