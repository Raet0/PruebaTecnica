package com.company.vehicles.dto;

public class VehicleStockRequestDto {

    private Long id;
    private Integer stock;

    public VehicleStockRequestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
