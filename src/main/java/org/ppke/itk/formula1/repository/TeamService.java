package org.ppke.itk.formula1.repository;

import org.ppke.itk.formula1.controller.dto.DriverDto;
import org.ppke.itk.formula1.controller.dto.TeamDto;
import org.ppke.itk.formula1.domain.Driver;
import org.ppke.itk.formula1.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final DriverService driverService;
    @Autowired
    public TeamService(TeamRepository teamRepository, DriverService driverService) {
        this.teamRepository = teamRepository;
        this.driverService = driverService;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    @Transactional
    public Team addNewTeam(Team team) {

        team = teamRepository.save(team);

        for (Driver driver : team.getDrivers()) {
            driver.setTeam(team);
            driverService.saveDriver(driver);
        }

        return teamRepository.getOne(team.getId());
    }

    public void deleteTeam(Integer teamId) {
        boolean exists = teamRepository.existsById(teamId);
        if (!exists) {
            throw new IllegalStateException("Team with id " + teamId + " does not exists!");
        }



        teamRepository.deleteById(teamId);
    }

    @Transactional
    public Team updateTeam(Team updatedTeam) {
        Team team = teamRepository.findById(updatedTeam.getId()).orElseThrow(() -> new IllegalStateException(
                "Driver with id " + updatedTeam.getId() + " does not exists!"
        ));

        team.setName(updatedTeam.getName());
        team.setNationality(updatedTeam.getNationality());
        team.setImagePath(updatedTeam.getImagePath());

        team.getDrivers().clear();
        for (Driver driver : updatedTeam.getDrivers()) {
            driver = driverService.getDriver(driver.getId());
            driver.setTeam(team);
            driver = driverService.saveDriver(driver);
            team.getDrivers().add(driver);
        }


        return teamRepository.save(team);

    }

    public Page<Team> findAll(Pageable pageable) {
        return teamRepository.findAll(pageable);
    }


    public Team getTeam(Integer teamId) {
        return teamRepository.findById(teamId).get();
    }

    public Team getTeamById(Integer teamId) {
        return teamRepository.findById(teamId).orElseThrow(() -> new IllegalStateException(
                "Team with id " + teamId + " does not exists!"
        ));
    }
}
