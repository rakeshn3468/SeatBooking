package com.example.SeatBooking.Repositories;

import com.example.SeatBooking.Entities.Tower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TowerRepository extends JpaRepository<Tower, Integer> {
  Tower findByTowerName(String  towerName);
}
