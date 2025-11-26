package com.test.habitree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.habitree.domain.Habit;

public interface HabitRepository extends JpaRepository<Habit, Long> {

}
