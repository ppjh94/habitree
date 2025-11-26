package com.test.habitree.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	private LocalDateTime joinDate;
	
	/* ===== Relationships ===== */
	
	@OneToMany(mappedBy ="user")
	private List<Habit> habits;
	
	@OneToMany(mappedBy = "user")
	private List<HabitSchedule> schedules;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HabitLog> logs = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Notification> notifications;
	
	/* ===== Constructors ===== */
	
	// JPA 기본 생성자 -> protected 권장
	protected User() {}
	
	/* ===== Static Factory (User 생성 메서드) ===== */
	
	public static User create(String email, String password, String nickname) {
		User user = new User();
		user.email = email;
		user.password = password;
		user.nickname = nickname;
		user.joinDate = LocalDateTime.now();
		return user;
	}
	
	/* ===== Change Methods (의도를 드러내는 변경 메서드) ===== */
	
	public void changeNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void changePassword(String encryptedPassword) {
		this.password = encryptedPassword;
	}
	
	public void changeProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	
	
}
