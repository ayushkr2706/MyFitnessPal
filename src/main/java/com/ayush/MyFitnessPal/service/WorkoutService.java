package com.ayush.MyFitnessPal.service;

import com.ayush.MyFitnessPal.model.User;
import com.ayush.MyFitnessPal.model.Workout;
import com.ayush.MyFitnessPal.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserService userService;

    //Adding Workout
    public Workout addWorkout(String userId, Workout workout){
        User user = userService.findById(userId);

        if(workout.getDuration() <= 0){
            throw new RuntimeException("Workout Duration must be greater than 0");
        }

        if(workout.getCalories() <= 0){
            throw new RuntimeException("Calories must be greater than 0");
        }

        if(workout.getType() == null || workout.getType().isEmpty()) {
            throw new RuntimeException("Workout type cannot be empty");
        }

        workout.setUser(user);
        return workoutRepository.save(workout);
    }

    //Total Calories
    public int getTotalCalories( String userId){
        User user = userService.findById(userId);
        List<Workout> workouts = workoutRepository.findByUser(user);
        int total = 0;
        for(Workout w : workouts){
            total+=w.getCalories();
        }
        return total;
    }

    //Total calories for today
    public int getDailyCalories(String userId){
        User user = userService.findById(userId);
        List<Workout> workouts = workoutRepository.findByUserAndDate(user, LocalDate.now());
        int total = 0;
        for(Workout w : workouts){
            total+=w.getCalories();
        }
        return total;
    }

    //Get Workout History

    public List<Workout> getWorkouts(String userId){
        User user = userService.findById(userId);
        List<Workout> wrk = workoutRepository.findByUser(user);
        return wrk;
    }
}
