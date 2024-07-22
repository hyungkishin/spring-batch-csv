package com.example.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class PersonFieldSetMapper implements FieldSetMapper<Person> {

    @Override
    public Person mapFieldSet(FieldSet fieldSet) throws BindException {
        Person contact = new Person();
        contact.setName(fieldSet.readString("이름"));
        contact.setPhone(fieldSet.readString("휴대폰"));
        return contact;
    }
}