package com.company.vehicles.service;

import java.util.List;

import com.company.vehicles.dto.VehicleResponseDto;
import com.company.vehicles.dto.VehicleStockRequestDto;
import com.company.vehicles.dto.OperationResponseDto;

public interface VehicleService {

    List<VehicleResponseDto> getAllActiveVehicles();

    List<VehicleResponseDto> getLowStockExpensive();

    OperationResponseDto deleteByModel(String model);

    VehicleResponseDto updateStock(VehicleStockRequestDto request);
}
