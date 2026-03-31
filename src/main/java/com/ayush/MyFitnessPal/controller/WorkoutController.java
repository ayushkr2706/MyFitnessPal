package com.ayush.MyFitnessPal.controller;

import com.ayush.MyFitnessPal.model.Workout;
import com.ayush.MyFitnessPal.service.WorkoutService;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;

    @PostMapping("/add")
    public Workout addWorkout(@RequestParam String userId,
                              @RequestBody Workout workout){

        return workoutService.addWorkout(userId, workout);
    }

    @GetMapping("/calories/total")
    public int getTotalCalories(@RequestParam String userId){
        return workoutService.getTotalCalories(userId);
    }

    @GetMapping("/calories/daily")
    public int getDailyCalories(@RequestParam String userId){
        return workoutService.getDailyCalories(userId);
    }

    @GetMapping("/history")
    public List<Workout> getWorkoutHistory(@RequestParam String userId){
        return workoutService.getWorkouts(userId);
    }
}
