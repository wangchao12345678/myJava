package com.wjm.model;

import java.util.*;

public class CountList {
    private String name;
    private Integer age;
    private String[] starr;
    private List<String> myList;
    private Map<String,String> myMap;
    private Properties myProps;
    private Date date;

    public CountList() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setStarr(String[] starr) {
        this.starr = starr;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CountList{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", starr=" + Arrays.toString(starr) +
                ", myList=" + myList +
                ", myMap=" + myMap +
                ", myProps=" + myProps +
                ", date=" + date +
                '}';
    }
}
