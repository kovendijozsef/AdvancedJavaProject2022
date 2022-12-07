package org.ppke.itk.formula1;

import org.ppke.itk.formula1.domain.Driver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


//insert into driver(name, points, dateOfBirth, racingNumber, imagePath, team_id) select 'Valteri Bottas', 0, '2000-04-12', 77, '', id  from team where name = 'Alfa Romeo';
@SpringBootApplication
public class Formula1Application {
	public static void main(String[] args) {
		SpringApplication.run(Formula1Application.class, args);
	}
}
