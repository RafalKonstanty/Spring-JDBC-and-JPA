package pl.konstanty.spring.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.konstanty.spring.database.jdbc.PersonJdbcDAO;

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
		logger.info(String.valueOf(dao.findById(1)));
	}
}