package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface parkingSpotRepository extends JpaRepository<ParkingSpot, UUID> {
}
