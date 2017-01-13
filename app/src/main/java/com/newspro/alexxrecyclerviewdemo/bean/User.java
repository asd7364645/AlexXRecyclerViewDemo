package com.newspro.alexxrecyclerviewdemo.bean;

/**
 * Created by Alex on 2017/1/13.
 * Alex
 */

public class User {

    private boolean isCome;
    private String name;

    public User(boolean isCome, String name) {
        this.isCome = isCome;
        this.name = name;
    }

    public boolean isCome() {
        return isCome;
    }

    public void setCome(boolean come) {
        isCome = come;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
