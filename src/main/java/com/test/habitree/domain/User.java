package com.test.habitree.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "tblUser")
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(nullable = false, unique = true, length = 200)
	private String email;
	
	@Column(nullable = false, length = 200)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String nickname;
	
	private String profileImg;

	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	private String joinDate;
	
	/* ===== Relationships ===== */
	
	@OneToMany(mappedBy ="user")
	private List<Habit> habits;
	
	@OneToMany(mappedBy = "user")
	private List<HabitSchedule> schecules;
	
	@OneToMany(mappedBy = "user")
	private List<HabitLog> logs;
	
	@OneToMany(mappedBy = "user")
	private List<Notification> notifications;
	
	
	
}
