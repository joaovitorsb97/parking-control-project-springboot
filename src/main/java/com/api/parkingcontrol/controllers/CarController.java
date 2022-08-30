package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.CarDto;
import com.api.parkingcontrol.models.CarModel;
import com.api.parkingcontrol.services.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @PostMapping
    public ResponseEntity<Object> saveCar(@RequestBody @Valid CarDto carDto){
        if(carService.existsByLicensePlateCar(carDto.getLicensePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Plate car is already exists!");
        }
        if(carService.existsByParkingSpotModel(carDto.getParkingSpotModel())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Parking spot is already used!");
        }
        var carModel = new CarModel();
        BeanUtils.copyProperties(carDto, carModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(carModel));
    }
    @GetMapping
    public ResponseEntity<List<CarModel>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(carService.findAll());
    }
}
