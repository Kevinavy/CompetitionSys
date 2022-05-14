package com.kevinavy.competitionsys.model.vo;

import com.kevinavy.competitionsys.model.po.User;

public class UserVo {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String clazz;
    private String institute;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserVo(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.clazz = user.getClazz();
        this.institute = user.getInstitute();
    }

    public UserVo() {
    }
}
