package org.ppke.itk.formula1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ppke.itk.formula1.domain.Driver;
import org.ppke.itk.formula1.domain.Team;
import org.springframework.lang.NonNull;

import javax.persistence.Transient;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {

    private Integer id;
    private String name;
    @Transient
    private Integer age;
    private Integer points;
    private LocalDate dataOfBirth;
    private String racingNumber;
    private String imagePath;
    private Team team;

    public static DriverDto fromDriver(Driver driver){



        return new DriverDto(
                driver.getId(),
                driver.getName(),
                driver.getAge(),
                driver.getPoints(),
                driver.getDataOfBirth(),
                driver.getRacingNumber(),
                driver.getImagePath(),
                driver.getTeam());
    }

    public static Driver toDriver(DriverDto driverDto){

        Driver driver = Driver.builder()
                .id(driverDto.getId())
                .name(driverDto.getName())
                .age(driverDto.getAge())
                .points(driverDto.getPoints())
                .racingNumber(driverDto.getRacingNumber())
                .dataOfBirth(driverDto.getDataOfBirth())
                .imagePath(driverDto.getImagePath())
                .build();

        return driver;

    }
}
