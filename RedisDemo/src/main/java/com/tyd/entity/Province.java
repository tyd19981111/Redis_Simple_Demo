package com.tyd.entity;

public class Province {
    private int id;
    private String name;

    // 省略构造方法


    public Province() {
    }

    public Province(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 省略get和set方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}