package com.kevinavy.competitionsys.model.vo;

import com.kevinavy.competitionsys.model.po.SignUp;

import java.sql.Timestamp;

public class SignUpVo {
    private Integer id;
    private Integer userId;
    private String username;
    private Integer competitionId;
    private Integer status;
    private String comment;
    private Timestamp createTime;

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public SignUpVo(SignUp signUp) {
        this.id = signUp.getId();
        this.userId = signUp.getUserId();
        this.competitionId = signUp.getCompetitionId();
        this.status = signUp.getStatus();
        this.comment = signUp.getComment();
        this.createTime = signUp.getCreateTime();
    }

    public SignUpVo() {
    }
}
