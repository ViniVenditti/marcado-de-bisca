package com.example.marcadordebisca.model;

import java.io.Serializable;

public class Jogadores implements Serializable {
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

    public Integer getDoing(Integer integer) {
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
