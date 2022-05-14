package com.kevinavy.competitionsys.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kevinavy.competitionsys.model.po.Competition;

import java.sql.Timestamp;

@TableName("competition")
public class CompetitionVo {
    private Integer id;
    private String name;
    private Integer type;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer level;
    private String organizer;
    private String place;
    private Integer approveStatus;
    private Timestamp approveTimeInstitute;
    private String approveCommentInstitute;
    private Timestamp approveTimeSchool;
    private String approveCommentSchool;
    private Timestamp createTime;
    private Integer finish;
    private Boolean hasApprove;

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Boolean getHasApprove() {
        return hasApprove;
    }

    public void setHasApprove(Boolean hasApprove) {
        this.hasApprove = hasApprove;
    }

    public Timestamp getApproveTimeInstitute() {
        return approveTimeInstitute;
    }

    public void setApproveTimeInstitute(Timestamp approveTimeInstitute) {
        this.approveTimeInstitute = approveTimeInstitute;
    }

    public Timestamp getApproveTimeSchool() {
        return approveTimeSchool;
    }

    public void setApproveTimeSchool(Timestamp approveTimeSchool) {
        this.approveTimeSchool = approveTimeSchool;
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getApproveCommentInstitute() {
        return approveCommentInstitute;
    }

    public void setApproveCommentInstitute(String approveCommentInstitute) {
        this.approveCommentInstitute = approveCommentInstitute;
    }

    public String getApproveCommentSchool() {
        return approveCommentSchool;
    }

    public void setApproveCommentSchool(String approveCommentSchool) {
        this.approveCommentSchool = approveCommentSchool;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public CompetitionVo(Competition competition) {
        this.id = competition.getId();
        this.name = competition.getName();
        this.type = competition.getType();
        this.startTime = competition.getStartTime();
        this.endTime = competition.getEndTime();
        this.level = competition.getLevel();
        this.organizer = competition.getOrganizer();
        this.place = competition.getPlace();
        this.approveStatus = competition.getApproveStatus();
        this.approveTimeInstitute = competition.getApproveTimeInstitute();
        this.approveCommentInstitute = competition.getApproveCommentInstitute();
        this.approveTimeSchool = competition.getApproveTimeSchool();
        this.approveCommentSchool = competition.getApproveCommentSchool();
        this.createTime = competition.getCreateTime();
        this.finish = competition.getFinish();
    }

    public CompetitionVo() {
    }
}
