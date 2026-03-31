package com.ayush.MyFitnessPal.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    //type = running, cycling, walking, gym etc
    private String type;
    private int duration; //in minutes
    private int calories;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Workout(){
        this.date = LocalDate.now();
    }
    public Workout(String type, int duration, int calories, User user) {
        this.type = type;
        this.duration = duration;
        this.calories = calories;
        this.user = user;
        this.date = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
