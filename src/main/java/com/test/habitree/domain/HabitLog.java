package com.test.habitree.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "tblHabitLog")
@Getter
public class HabitLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long logId;
	
	@ManyToOne
	@JoinColumn(name = "scheduleId")
	private HabitSchedule scheduleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
	
	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	private String completeAt;
	
}
