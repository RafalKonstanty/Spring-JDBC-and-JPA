package pl.konstanty.spring.database.entity;

import javax.persistence.*;
import java.util.Date;

//@Table(name = "person")
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //todo Without setting up strategy there was an error with ID not Null
    private int id;
//    @Column(name = "name")
    private String name;
    private String location;
    private Date birthDate;

    // Remember to create EMPTY constructor - bc. BeanPropertyRowMapper
    public Person() {
    }

    public Person(String name, String location, Date birth_date) {
        this.name = name;
        this.location = location;
        this.birthDate = birth_date;
    }

    public Person(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birth_date=" + birthDate +
                '}';
    }
}
