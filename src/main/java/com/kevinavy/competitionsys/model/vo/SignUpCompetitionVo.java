package com.kevinavy.competitionsys.model.vo;

import com.kevinavy.competitionsys.model.dto.SignUpCompetitionDto;

import java.sql.Timestamp;

public class SignUpCompetitionVo {
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
    private Integer finish;
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

    public void setSignUpStatus(Integer signUpStatus) {
        this.signUpStatus = signUpStatus;
    }

    public Integer getSignUpStatus() {
        return signUpStatus;
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

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public Timestamp getApproveTimeInstitute() {
        return approveTimeInstitute;
    }

    public void setApproveTimeInstitute(Timestamp approveTimeInstitute) {
        this.approveTimeInstitute = approveTimeInstitute;
    }

    public String getApproveCommentInstitute() {
        return approveCommentInstitute;
    }

    public void setApproveCommentInstitute(String approveCommentInstitute) {
        this.approveCommentInstitute = approveCommentInstitute;
    }

    public Timestamp getApproveTimeSchool() {
        return approveTimeSchool;
    }

    public void setApproveTimeSchool(Timestamp approveTimeSchool) {
        this.approveTimeSchool = approveTimeSchool;
    }

    public String getApproveCommentSchool() {
        return approveCommentSchool;
    }

    public void setApproveCommentSchool(String approveCommentSchool) {
        this.approveCommentSchool = approveCommentSchool;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public Timestamp getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(Timestamp signUpTime) {
        this.signUpTime = signUpTime;
    }

    public SignUpCompetitionVo(SignUpCompetitionDto signUpCompetitionDto) {
        this.id = signUpCompetitionDto.getId();
        this.name = signUpCompetitionDto.getName();
        this.type = signUpCompetitionDto.getType();
        this.startTime = signUpCompetitionDto.getStartTime();
        this.endTime = signUpCompetitionDto.getEndTime();
        this.level = signUpCompetitionDto.getLevel();
        this.organizer = signUpCompetitionDto.getOrganizer();
        this.place = signUpCompetitionDto.getPlace();
        this.approveStatus = signUpCompetitionDto.getApproveStatus();
        this.approveTimeInstitute = signUpCompetitionDto.getApproveTimeInstitute();
        this.approveCommentInstitute = signUpCompetitionDto.getApproveCommentInstitute();
        this.approveTimeSchool = signUpCompetitionDto.getApproveTimeSchool();
        this.approveCommentSchool = signUpCompetitionDto.getApproveCommentSchool();
        this.finish = signUpCompetitionDto.getFinish();
        this.signUpId = signUpCompetitionDto.getSignUpId();
        this.signUpTime = signUpCompetitionDto.getSignUpTime();
        this.signUpStatus = signUpCompetitionDto.getSignUpStatus();
        this.signUpComment = signUpCompetitionDto.getSignUpComment();
    }

    public SignUpCompetitionVo() {
    }
}
