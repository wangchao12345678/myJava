package com.wjm.model;

import java.util.*;

public class Count {
  private String name;
  private Integer age;
//  private String[] starr;
//  private List<String> myList;
//  private Map<String,String> myMap;
//  private Properties myProps;
  Date date;

  public Count() {

  }

  public Count(String name, Integer age, Date date) {
    this.name = name;
    this.age = age;
    this.date=date;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Count{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", date=" + date +
            '}';
  }
}
