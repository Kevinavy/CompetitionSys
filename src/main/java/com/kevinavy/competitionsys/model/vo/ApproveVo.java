package com.kevinavy.competitionsys.model.vo;

import com.kevinavy.competitionsys.model.po.SignUp;

import java.sql.Timestamp;

public class ApproveVo {
    private Integer competitionId;
    private Integer status;
    private String comment;

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
}
