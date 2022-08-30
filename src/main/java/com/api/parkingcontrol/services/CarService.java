package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.CarModel;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarService{

    @Autowired
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public List<CarModel> findAll(){
        return carRepository.findAll();
    }
    @Transactional
    public CarModel save(CarModel carModel){
        return carRepository.save(carModel);
    }
    public boolean existsByLicensePlateCar(String licensePlateCar){
        return carRepository.existsByLicensePlateCar(licensePlateCar);
    }
    public boolean existsByParkingSpotModel(ParkingSpotModel parkingSpotModel){
        return carRepository.existsByParkingSpotModel(parkingSpotModel);
    }
}
