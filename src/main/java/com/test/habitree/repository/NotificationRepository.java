package com.test.habitree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.habitree.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
