package com.kevinavy.competitionsys.model.vo;

import com.kevinavy.competitionsys.model.po.Game;

import java.sql.Timestamp;

public class GameVo {
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

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public GameVo(Game game) {
        this.id = game.getId();
        this.name = game.getName();
        this.place = game.getPlace();
        this.startTime = game.getStartTime();
        this.endTime = game.getEndTime();
        this.home = game.getHome();
        this.homeScore = game.getHomeScore();
        this.visit = game.getVisit();
        this.visitScore = game.getVisitScore();
        this.fatherCompetition = game.getFatherCompetition();
        this.finish = game.getFinish();
    }

    public GameVo() {
    }
}
