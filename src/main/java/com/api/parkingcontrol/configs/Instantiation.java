package com.api.parkingcontrol.configs;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.CarRepository;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Profile("test")
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {
        ParkingSpotModel parkingSpotModel1 = new ParkingSpotModel(null, "405F", Instant.parse("2022-06-20T19:53:07Z"), "F");
        ParkingSpotModel parkingSpotModel2 = new ParkingSpotModel(null, "603E", Instant.parse("2022-06-20T20:51:02Z"), "E");

        parkingSpotRepository.saveAll(Arrays.asList(parkingSpotModel1, parkingSpotModel2));


    }
}
