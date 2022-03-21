package pl.konstanty.spring.database.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.konstanty.spring.database.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {

}
