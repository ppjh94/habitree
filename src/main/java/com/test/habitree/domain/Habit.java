package com.test.habitree.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "tblHabit")
@Getter
public class Habit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long habitId;
	
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;
	
	@Column(nullable = false, length = 200)
	private String title;
	
	@Column(length = 500)
	private String description;
	
	private String repeatType;
	
	@Column(length = 50)
	private String repeatDays;
	
	private String targetTime;
	
	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	private String createdAt;
	
	@Column(length = 1)
	private String isActive;
	
	/* ===== Relationships ===== */
	
	@OneToMany(mappedBy = "habit")
	private List<HabitSchedule> schedules;
	
}
