package org.ppke.itk.formula1.repository;

import org.ppke.itk.formula1.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {


    //ez nem kell majd
    @Query("select d from Driver d where d.racingNumber = ?1")
    Optional<Driver> findByRacingNumber(@NonNull String racingNumber);

}
