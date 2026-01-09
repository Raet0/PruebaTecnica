package com.company.vehicles.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.company.vehicles.dto.OperationResponseDto;
import com.company.vehicles.dto.VehicleResponseDto;
import com.company.vehicles.dto.VehicleStockRequestDto;
import com.company.vehicles.entity.Vehicle;
import com.company.vehicles.mapper.VehicleMapper;
import com.company.vehicles.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleResponseDto> getAllActiveVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findByDeleted("N");

        return vehicles.stream()
                .map(VehicleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleResponseDto> getLowStockExpensive() {
        List<Vehicle> vehicles =
                vehicleRepository.findByDeletedAndPriceGreaterThanAndStockLessThan("N", 20000.0, 10);

        return vehicles.stream()
                .map(VehicleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OperationResponseDto deleteByModel(String model) {

        Vehicle vehicle = vehicleRepository.findByModel(model)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        if ("S".equals(vehicle.getDeleted())) {
            throw new RuntimeException("Vehicle already deleted");
        }

        vehicle.setDeleted("S");
        vehicleRepository.save(vehicle);

        return new OperationResponseDto("Vehicle deleted successfully");
    }

    @Override
    public VehicleResponseDto updateStock(VehicleStockRequestDto request) {

        if (request.getStock() == null || request.getStock() < 0) {
            throw new RuntimeException("Invalid request data");
        }

        Vehicle vehicle = vehicleRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        vehicle.setStock(request.getStock());
        vehicleRepository.save(vehicle);

        return VehicleMapper.toResponse(vehicle);
    }
}
