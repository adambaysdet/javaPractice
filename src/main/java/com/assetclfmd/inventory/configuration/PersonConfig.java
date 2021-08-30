package com.assetclfmd.inventory.configuration;

import com.assetclfmd.inventory.entity.Person;
import com.assetclfmd.inventory.repository.PersonRepository;
import com.assetclfmd.inventory.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PersonConfig {
    @Autowired
    private PersonService service;

    @Bean
    public void addPerson(){
        Person p1= new Person();
        p1.setName("Ahmet Sodek");
        p1.setBalance(89);
        p1.setEmail("ahmet@gmail.com");
        p1.setDob(LocalDate.of(2004,03,13));

        Person p2= new Person();
        p2.setName("ismail");
        p2.setBalance(168);
        p2.setEmail("ismail@gmail.com");
        p2.setDob(LocalDate.of(2018,1,5));

        service.savePersonList(List.of(p1,p2));
               // saveAll(List.of(p1,p2));

    }
}
