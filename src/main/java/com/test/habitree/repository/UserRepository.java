package com.test.habitree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.habitree.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// 이메일로 사용자 찾기 (나중에 로그인용)
	User findByEmail(String email);
}
