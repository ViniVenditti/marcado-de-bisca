package com.example.marcadordebisca.model;

public class Jogadores {
    private String name;
    private Integer doing;
    private Integer done;
    private Integer points;

    public Jogadores() {
    }

    public Jogadores(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDoing() {
        return doing;
    }

    public void setDoing(Integer doing) {
        this.doing = doing;
    }

    public Integer getDone() {
        return done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
