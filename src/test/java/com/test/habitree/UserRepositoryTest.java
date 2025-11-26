package com.test.habitree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.test.habitree.domain.User;
import com.test.habitree.repository.UserRepository;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	void testSaveUser() {
		
		// 1) User 생성 (Setter 없음 -> create() 사용)
		User user = User.create("test@naved.com", "1234", "tester");
		
		// 2) 저장
		User savedUser = userRepository.save(user);

		// 3) 검증
		assertThat(savedUser.getUserId()).isNotNull();
		assertThat(savedUser.getEmail()).isNotNull();
		
		System.out.println("저장된 userId = " + savedUser.getUserId());
		System.out.println("저장된 userEmail = " + savedUser.getEmail());
		
	}
}







