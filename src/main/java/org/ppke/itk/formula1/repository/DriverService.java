package org.ppke.itk.formula1.repository;

import org.ppke.itk.formula1.controller.dto.DriverDto;
import org.ppke.itk.formula1.domain.Driver;
import org.ppke.itk.formula1.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getDrivers(){
        return driverRepository.findAll();
    }

    public Driver addNewDriver(Driver driver) {
        Optional<Driver> driverOptional = driverRepository.findByRacingNumber(driver.getRacingNumber());
        if (driverOptional.isPresent()) {
            throw new IllegalStateException("Racing number is already taken!");
        }
        return driverRepository.save(driver);
    }



    public void deleteDriver(Integer driverId) {
        boolean exists = driverRepository.existsById(driverId);
        if (!exists) {
            throw new IllegalStateException("Driver with id " + driverId + " does not exists!");
        }
        driverRepository.deleteById(driverId);
    }

    @Transactional
    public Driver saveDriver(Driver driver){
        return driverRepository.save(driver);
    }

    @Transactional
    public void updateDriver(Integer driverId, Integer points, String team) {
        Driver driver = driverRepository.findById(driverId).orElseThrow(() -> new IllegalStateException(
                "Driver with id " + driverId + " does not exists!"
        ));

        if (points != null && points > 0 && !points.equals(driver.getPoints())) {
            driver.setPoints(points);
        }
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }


    public Driver getDriver(Integer id){
        return driverRepository.findById(id).get();
    }
}
