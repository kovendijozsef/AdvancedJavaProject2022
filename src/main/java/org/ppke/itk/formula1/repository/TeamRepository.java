package org.ppke.itk.formula1.repository;

import org.ppke.itk.formula1.domain.Driver;
import org.ppke.itk.formula1.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    //ez nem kell majd
    @Query("select d from Driver d where d.id=:team_id")
    List<Driver> findByDriversIn(Integer team_id);

}
