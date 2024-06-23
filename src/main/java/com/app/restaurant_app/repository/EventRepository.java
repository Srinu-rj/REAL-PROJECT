package com.app.restaurant_app.repository;

import com.app.restaurant_app.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Events, Long>{

}
