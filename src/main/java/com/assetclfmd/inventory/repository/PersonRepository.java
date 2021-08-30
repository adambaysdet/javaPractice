package com.assetclfmd.inventory.repository;


import com.assetclfmd.inventory.entity.Person;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>, JpaSpecificationExecutor {
    List<Person> findByName(String name);

    @Query("FROM Person WHERE dob = ?1")
    List<Person> findByDOB(LocalDate dob);

    @Query("FROM Person WHERE email = ?1")
    List<Person> findByEmail(String email);

    static Specification<Person> hasName(Optional<String> name){
        return (Person, cq,cb) -> cb.like(Person.get("name"), name.orElse("") + "%");
    }
    static Specification<Person> hasEmail(Optional<String> email){
        return (Person, cq,cb) -> cb.like(Person.get("email"),email.orElse("") + "%");
    }
    static Specification<Person> hasDob(Optional<LocalDate> dob){
        if (dob.isPresent()) {
            System.out.println(dob);
            return (Person, cq, cb) -> cb.equal(Person.get("dob"), dob);
        }
       // return (Person, cq,cb) -> cb.notEqual(Person.get("dob"),null);
       // return (Person, cq,cb) -> cb.equal(Person.get("dob"),dob.orElse(LocalDate.parse("2004-03-13")));
        return (Person, cq,cb) -> cb.notEqual(Person.get("dob"),LocalDate.of(0001, 1, 1));
    }
}