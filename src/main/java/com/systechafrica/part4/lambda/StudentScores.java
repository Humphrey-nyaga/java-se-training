package com.systechafrica.part4.lambda;

import java.util.List;
import java.util.Map;

public class StudentScores {
    private int id;
    private  List<Integer> scores;
    
    public StudentScores(int id, List<Integer> scores) {
        this.id = id;
        this.scores = scores;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Integer> getScores() {
        return scores;
    }
    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

}
