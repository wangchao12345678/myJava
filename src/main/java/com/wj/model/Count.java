package com.wj.model;

import com.wj.Interface.Acc;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component(value = "count")//value的值相当于标识
@Scope(value = "prototype")
public class Count implements Acc {
    private int id;
    private String name;
    private int age;
    private String address;
    private String phone;

    public Count(int id, String name, int age, String address, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public Count() {
    }
    public void setCount(String name,int age,String address,String phone){
        this.name=name;
        this.age=age;
        this.address=address;
        this.phone=phone;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void show() {
        System.out.println("我是count对象");
    }

    @Override
    public String toString() {
        return "Count{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
