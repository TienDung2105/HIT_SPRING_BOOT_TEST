package org.example.hotelbooking.repository;

import org.example.hotelbooking.domain.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, String> {
}
