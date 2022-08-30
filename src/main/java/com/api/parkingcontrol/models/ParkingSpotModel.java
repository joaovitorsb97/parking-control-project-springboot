package com.api.parkingcontrol.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_parking_spot")
public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant registrationMoment;
    @Column(nullable = false, length = 30)
    private String block;

    @OneToOne(mappedBy = "parkingSpotModel", cascade = CascadeType.ALL)
    private CarModel car;

    public ParkingSpotModel() {
    }

    public ParkingSpotModel(UUID id, String parkingSpotNumber, Instant registrationMoment, String block) {
        this.id = id;
        this.parkingSpotNumber = parkingSpotNumber;
        this.registrationMoment = registrationMoment;
        this.block = block;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public Instant getRegistrationMoment() {
        return registrationMoment;
    }

    public void setRegistrationMoment(Instant registrationMoment) {
        this.registrationMoment = registrationMoment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpotModel that = (ParkingSpotModel) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
