package com.ayush.MyFitnessPal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ayush.MyFitnessPal.model.Workout;
import com.ayush.MyFitnessPal.model.User;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, String>{
    List<Workout> findByUser(User user);
    List<Workout> findByUserAndDate(User user, LocalDate date);
}