package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.CarModel;
import com.api.parkingcontrol.models.ParkingSpotModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CarDto {

    @NotBlank
    @Size(max = 7)
    private String licensePlateCar;
    @NotBlank
    private String brandCar;
    @NotBlank
    private String modelCar;
    @NotBlank
    private String colorCar;
    @NotBlank
    private ParkingSpotModel parkingSpotModel;

    public CarDto(CarModel carModel){
        this.licensePlateCar = carModel.getLicensePlateCar();
        this.brandCar = carModel.getBrandCar();
        this.modelCar = carModel.getModelCar();
        this.colorCar = carModel.getColorCar();
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public ParkingSpotModel getParkingSpotModel() {
        return parkingSpotModel;
    }

    public void setParkingSpotModel(ParkingSpotModel parkingSpotModel) {
        this.parkingSpotModel = parkingSpotModel;
    }
}
