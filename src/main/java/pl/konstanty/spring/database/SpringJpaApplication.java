package pl.konstanty.spring.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.konstanty.spring.database.entity.Person;
import pl.konstanty.spring.database.jpa.PersonJpaRepository;

import java.util.Date;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	@Autowired
	PersonJpaRepository repository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("user id: {}",repository.findById(1));

		logger.info("Updating person: {}" ,repository.update(new Person(2,"James", "US", new Date())));
		logger.info("Inserting person: {}",repository.insert(new Person( "Nathan", "Poland", new Date())));

	}
}
