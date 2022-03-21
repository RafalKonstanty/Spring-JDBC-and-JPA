package pl.konstanty.spring.database.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.konstanty.spring.database.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional // when doing some updating - usually in Services not repositories
public class PersonJpaRepository {

    //connect to the database
    @PersistenceContext
    private EntityManager entityManager;
    // all entities are stored in PersistenceContext, EntityManager is Interface to the PersistenceContext
    // all operations have to gone through entityManager

    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person) {
        return entityManager.merge(person); //update or insert u call .merge()
        // it knows if the Id is set in the person or not, if it is Set it will update, if not it will Insert it in
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }


}
