package com.kevinavy.competitionsys.model.dto;

import java.sql.Time;
import java.sql.Timestamp;

public class SignUpCompetitionDto {
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
    private Timestamp approveTimeInstitute;
    private String approveCommentInstitute;
    private Timestamp approveTimeSchool;
    private String approveCommentSchool;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer isDelete;
    private Integer signUpId;
    private Timestamp signUpTime;
    private Integer signUpStatus;
    private String signUpComment;

    public String getSignUpComment() {
        return signUpComment;
    }

    public void setSignUpComment(String signUpComment) {
        this.signUpComment = signUpComment;
    }

    public Integer getSignUpId() {
        return signUpId;
    }

    public void setSignUpId(Integer signUpId) {
        this.signUpId = signUpId;
    }

    public Integer getSignUpStatus() {
        return signUpStatus;
    }

    public void setSignUpStatus(Integer signUpStatus) {
        this.signUpStatus = signUpStatus;
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

    public Timestamp getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(Timestamp signUpTime) {
        this.signUpTime = signUpTime;
    }
}
