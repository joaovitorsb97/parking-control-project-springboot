package com.api.parkingcontrol.dtos;

import javax.validation.constraints.NotBlank;

public class ParkingSpotDto {

    @NotBlank
    private String parkingSpotNumber;
    @NotBlank
    private String block;

    /* @NotBlank
    private CarDto carDto; */

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
