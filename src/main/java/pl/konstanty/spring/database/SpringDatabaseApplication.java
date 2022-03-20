package pl.konstanty.spring.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.konstanty.spring.database.entity.Person;
import pl.konstanty.spring.database.jdbc.PersonJdbcDAO;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class SpringDatabaseApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDAO dao;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// when SpringApplicationContext is ready this code will be run
//		System.out.println(dao.findAll());
//		logger.info(String.valueOf(dao.findAll()));
//		logger.info(String.valueOf(dao.findById(1)));
//		logger.info(String.valueOf("Number of rows affected: " + dao.deleteById(2)));
		logger.info(String.valueOf(dao.insert(new Person("Stephany", "Berlin", new Date()))));
		logger.info(String.valueOf(dao.update(new Person("Jacky", "Moscau", new Date()), 3)));
	}
}
