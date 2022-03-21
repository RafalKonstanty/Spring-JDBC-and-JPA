package pl.konstanty.spring.database.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.konstanty.spring.database.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

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

    public void deleteById(int id){
        Person person = findById(id);
        entityManager.remove(person);
    }

    // HQL - hibernate Query Language, with an entity manager we have to write in HQL
    // JPQL - java persistence query language
    // NamedQuery - used with JPQL
    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }
    // we can define named query on each Entity

}
