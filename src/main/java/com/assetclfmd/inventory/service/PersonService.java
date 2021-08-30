package com.assetclfmd.inventory.service;

import com.assetclfmd.inventory.entity.Person;
import com.assetclfmd.inventory.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.assetclfmd.inventory.repository.PersonRepository.*;

@Service
public class PersonService {
    @Autowired
    private PersonRepository rep;

    public Object savePerson(Person person){
        List<Person> optionalPerson = rep.findByEmail(person.getEmail());
//        if (optionalPerson.size()>0) { //return "Email is already taken";
//            throw new IllegalStateException("Email is already taken");
//        }

        return rep.save(person);
    }
    public List<Person> savePersonList(List<Person> personList){
        for (Person person:personList
             ) {savePerson(person);
        }
        return personList;
    }
    @Transactional
    public List<Person> getPersonList(Optional<String> name, Optional<String>  email, Optional<LocalDate> dob){
//        if (email !=null) {
//            if (name !=null){
//              return  rep.findByEmail(email).stream().filter(p->p.getName().equals(name)).collect(Collectors.toList());
//            }
//            return  rep.findByEmail(email);
//        };
//        if (name !=null) return rep.findByName(name);
//        if (dob !=null) return rep.findByDOB(dob);
//
//        return rep.findAll();
       // if(name.isEmpty()) name= Optional.of("");
       // if(email.isEmpty()) email= Optional.of("");
       // System.out.println("name= "+name.) ; //+ "email= "+email.get());
        //Specification.where(hasName(name)).and(hasEmail(email))
       return  rep.findAll(Specification
               .where(hasName(name))
               .and(hasEmail(email))
                       .and(hasDob(dob))
            );

      //  return  rep.findAll();
    }
    public Person getPersonById(int id){
        return rep.findById(id).orElse(null);
    }
    public List<Person> getPersonByName(String name) {
        return rep.findByName(name);
    }
    public List<Person> getPersonByEmail(String email) {
        return rep.findByEmail(email);
    }
    public List<Person> getPersonByDOB(LocalDate dob) {
        return rep.findByDOB(dob);
    }
    public String deletePerson(int id){
        System.out.println("id ="+id);
        if (!rep.existsById(id)) throw new IllegalStateException("Person with this id "+ id+ " does not exist");
        rep.delete(getPersonById(id));
        return "Person removed" + getPersonById(id);
    }
    public Person updatePerson(Person person){
        Person update = getPersonById(person.getId());
        update.setName(person.getName());
        update.setDob(person.getDob());
        update.setBalance(person.getBalance());
        update.setEmail(person.getEmail());
        return rep.save(update);
    }




}