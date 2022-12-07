package org.ppke.itk.formula1.controller;

import lombok.AllArgsConstructor;
import org.ppke.itk.formula1.controller.dto.DriverDto;
import org.ppke.itk.formula1.controller.dto.TeamDto;
import org.ppke.itk.formula1.domain.Driver;
import org.ppke.itk.formula1.domain.Team;
import org.ppke.itk.formula1.repository.DriverService;
import org.ppke.itk.formula1.repository.TeamRepository;
import org.ppke.itk.formula1.repository.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public TeamDto registerNewTeam(@RequestBody TeamDto teamDto){
        System.out.println(teamDto.getName());
        System.out.println(teamDto.getNationality());
        Team team = teamService.addNewTeam(TeamDto.toTeam(teamDto));
        return TeamDto.fromTeam(team);
    }

    @DeleteMapping(path = "{teamId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeam(@PathVariable("teamId") Integer teamId){

        List<Driver> driversInTeam = teamService.getTeamById(teamId).getDrivers();
        System.out.println(driversInTeam);


        for (Driver driver: driversInTeam) {
            driver.setTeam(null);
        }
        teamService.deleteTeam(teamId);
    }

    @PutMapping(path = "{teamId}")
    public TeamDto updateTeam(@PathVariable("teamId") Integer teamId, @RequestBody TeamDto teamDto){

        teamDto.setId(teamId);
        Team team = teamService.updateTeam(TeamDto.toTeam(teamDto));

        return TeamDto.fromTeam(team);

    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<TeamDto> getTeams(Pageable pageable) {

        Page<Team> teams = teamService.findAll(pageable);
        Page<TeamDto> teamsDto = new PageImpl<>(teams.stream().map(TeamDto::fromTeam).toList(), pageable, teams.getTotalElements());

        return teamsDto.toList();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("{teamId}")
    public TeamDto getTeam(@PathVariable Integer teamId){
        return TeamDto.fromTeam(teamService.getTeam(teamId));

    }




}
