package com.test.habitree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.habitree.domain.HabitLog;

public interface HabitLogRepository extends JpaRepository<HabitLog, Long>{

}
