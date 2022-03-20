package pl.konstanty.spring.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.konstanty.spring.database.entity.Person;

import java.util.List;

@Repository
public class PersonJdbcDAO {

    //Its provided thanks to the @AutoConfiguration
    @Autowired
    JdbcTemplate jdbcTemplate;

    //select * from Person
    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person findById(int id) {
        //when querrien for specific object
        return jdbcTemplate.queryForObject("SELECT * FROM person where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM person where id=?", id);

    }



}
