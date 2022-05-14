package com.kevinavy.competitionsys.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kevinavy.competitionsys.model.vo.GameVo;

import java.sql.Timestamp;

@TableName("game")
public class Game {
    @TableId
    private Integer id;
    private String name;
    private String place;
    private Timestamp startTime;
    private Timestamp endTime;
    private String home;
    private Integer homeScore;
    private String visit;
    private Integer visitScore;
    private Integer fatherCompetition;
    private Integer finish;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer isDelete;

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public Integer getVisitScore() {
        return visitScore;
    }

    public void setVisitScore(Integer visitScore) {
        this.visitScore = visitScore;
    }

    public Integer getFatherCompetition() {
        return fatherCompetition;
    }

    public void setFatherCompetition(Integer fatherCompetition) {
        this.fatherCompetition = fatherCompetition;
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

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Game(GameVo gameVo) {
        this.id = gameVo.getId();
        this.name = gameVo.getName();
        this.place = gameVo.getPlace();
        this.startTime = gameVo.getStartTime();
        this.endTime = gameVo.getEndTime();
        this.home = gameVo.getHome();
        this.homeScore = gameVo.getHomeScore();
        this.visit = gameVo.getVisit();
        this.visitScore = gameVo.getVisitScore();
        this.fatherCompetition = gameVo.getFatherCompetition();
        this.finish = gameVo.getFinish();
    }

    public Game() {
    }
}
