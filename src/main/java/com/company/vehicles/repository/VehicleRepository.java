package com.company.vehicles.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.vehicles.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByDeleted(String deleted);

    List<Vehicle> findByDeletedAndPriceGreaterThanAndStockLessThan(
            String deleted, Double price, Integer stock);

    Optional<Vehicle> findByModel(String model);
}
