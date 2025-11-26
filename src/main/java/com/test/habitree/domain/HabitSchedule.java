package com.test.habitree.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "tblHabitSchedule")
@Getter
public class HabitSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleId;
	
	@ManyToOne
	@JoinColumn(name = "habitId")
	private Habit habit;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	private String scheduleDate;
	
	
	private String status;
	
	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	private String createdAt;
	
	/* ===== Relationships ===== */
	
	private List<HabitLog> logs;
	
}
