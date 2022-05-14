package com.kevinavy.competitionsys.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kevinavy.competitionsys.model.vo.CompetitionVo;

import java.sql.Timestamp;

@TableName("competition")
public class Competition {
    @TableId
    private Integer id;
    private String name;
    private Integer type;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer level;
    private String organizer;
    private String place;
    private Integer finish;
    private Integer approveStatus;
    private String approveCommentInstitute;
    private Timestamp approveTimeInstitute;
    private Timestamp approveTimeSchool;
    private String approveCommentSchool;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer isDelete;

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

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Competition(CompetitionVo competitionVo) {
        this.id = competitionVo.getId();
        this.name = competitionVo.getName();
        this.type = competitionVo.getType();
        this.startTime = competitionVo.getStartTime();
        this.endTime = competitionVo.getEndTime();
        this.level = competitionVo.getLevel();
        this.organizer = competitionVo.getOrganizer();
        this.place = competitionVo.getPlace();
        this.finish = competitionVo.getFinish();
    }

    public Competition() {
    }
}
