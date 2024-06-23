package com.app.restaurant_app.repository;

import com.app.restaurant_app.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
//
//	public List<Notification> findByCustomerId(Long userId);
//	public List<Notification> findByRestaurantId(Long restaurantId);

}
