package pl.konstanty.spring.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.konstanty.spring.database.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {

    //Its provided thanks to the @AutoConfiguration
    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {
        //how do you want to map it to the Person
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getDate("birth_date"));
            return person;
        }
        // lot of times table definitions will be different, it;s for mapping data from table
    }

    //select * from Person
    public List<Person> findAll() {
//        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<Person>(Person.class));
        return jdbcTemplate.query("SELECT * FROM person", new PersonRowMapper());
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
    public int insert(Person person) {
        return jdbcTemplate.update("INSERT INTO PERSON (name, location, birth_date) VALUES (?,?,?)", person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()));
    }

    //it will return int number of affected Rows
    public int update(Person person, int id) {
        return jdbcTemplate.update(
                "UPDATE PERSON SET name=?," +
                        " location=?," +
                        " birth_date=?" +
                        " WHERE id=?",
                person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), id);
    }


}
