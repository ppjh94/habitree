package com.test.habitree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.habitree.domain.HabitSchedule;

public interface HabitScheduleRepository extends JpaRepository<HabitSchedule, Long> {

}
