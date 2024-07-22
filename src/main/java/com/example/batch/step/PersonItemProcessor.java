package com.example.batch.step;

import com.example.batch.domain.Person;
import com.example.batch.domain.dto.PersonDTO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class PersonItemProcessor implements ItemProcessor<PersonDTO, Person> {

    @Override
    public Person process(PersonDTO item) throws Exception {
        return item.toEntity();
    }

}