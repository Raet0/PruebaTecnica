package com.company.vehicles.mapper;

import com.company.vehicles.entity.Vehicle;
import com.company.vehicles.dto.VehicleResponseDto;

public class VehicleMapper {

    private VehicleMapper() {
    }

    public static VehicleResponseDto toResponse(Vehicle vehicle) {

        if (vehicle == null) {
            return null;
        }

        VehicleResponseDto dto = new VehicleResponseDto();

        dto.setId(vehicle.getId());
        dto.setBrand(vehicle.getBrand());
        dto.setModel(vehicle.getModel());
        dto.setPrice(vehicle.getPrice());
        dto.setStock(vehicle.getStock());

        return dto;
    }
}
