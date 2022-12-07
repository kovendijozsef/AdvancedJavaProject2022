package org.ppke.itk.formula1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ppke.itk.formula1.domain.Driver;
import org.ppke.itk.formula1.domain.Team;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {

    private Integer id;
    private String name;
    private String nationality;
    private String imagePath;
    private List<DriverDto> drivers;
    private int points;


    public static TeamDto fromTeam(Team team){

        List<DriverDto> drivers = team.getDrivers().stream().map(DriverDto::fromDriver).toList();

        int points = 0;

        for (DriverDto driver: drivers) {
            points += driver.getPoints();
        }

        return new TeamDto(
                team.getId(),
                team.getName(),
                team.getNationality(),
                team.getImagePath(),
                drivers,
                points
                );
    }

    public static Team toTeam(TeamDto teamDto){
        List<Driver> drivers = teamDto.getDrivers().stream().map(DriverDto::toDriver).toList();

        Team team = Team.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .nationality(teamDto.getNationality())
                .imagePath(teamDto.getImagePath())
                .drivers(drivers)
                .build();

        return team;
    }

}
