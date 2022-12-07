package org.ppke.itk.formula1.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.ppke.itk.formula1.controller.dto.DriverDto;
import org.ppke.itk.formula1.controller.dto.TeamDto;
import org.ppke.itk.formula1.domain.Driver;
import org.ppke.itk.formula1.domain.Team;
import org.ppke.itk.formula1.repository.DriverRepository;
import org.ppke.itk.formula1.repository.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DriverController {

    private final DriverService driverService;

//    @PostMapping
//    public DriverDto registerNewDriver(@RequestBody DriverDto driverDto){
//
//        Driver driver = driverService.addNewDriver(DriverDto.toDriver(driverDto));
//        return DriverDto.fromDriver(driver);
//    }

//    @DeleteMapping(path = "{driverId}")
//    public void deleteDriver(@PathVariable("driverId") Integer driverId){
//        driverService.deleteDriver(driverId);
//    }

//    @PutMapping(path = "{driverId}")
//    public void updateDriver(
//            @PathVariable("driverId") Integer driverId,
//            @RequestParam(required = false) Integer points,
//            @RequestParam(required = false) String team
//    ){
//        driverService.updateDriver(driverId, points, team);
//    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<DriverDto> getDrivers() {

        List<Driver> drivers = driverService.findAll();
        List<DriverDto> driversDto = new ArrayList<>();
        for(Driver driver : drivers) {
            driversDto.add(DriverDto.fromDriver(driver));
        }
        return driversDto;
    }

    @GetMapping("{driverId}")
    public DriverDto getDriver(@PathVariable Integer driverId){
        return DriverDto.fromDriver(driverService.getDriver(driverId));
    }


}
