package pl.konstanty.spring.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.konstanty.spring.database.entity.Person;

import java.sql.Timestamp;
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

    //it will return int number of affected Rows
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM person where id=?", id);
    }

    //it will return int number of affected Rows
    public int insert(Person person){
        return jdbcTemplate.update("INSERT INTO PERSON (name, location, birth_date) VALUES (?,?,?)", person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()));
    }

    //it will return int number of affected Rows
    public int update(Person person, int id){
        return jdbcTemplate.update(
                "UPDATE PERSON SET name=?," +
                        " location=?," +
                        " birth_date=?" +
                        " WHERE id=?",
                person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), id);
    }



}
