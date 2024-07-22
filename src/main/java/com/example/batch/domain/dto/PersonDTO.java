package com.example.batch.domain.dto;

import com.example.batch.domain.Person;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {

//    @CsvBindByName(column = "이름")
    private String name;

//    @CsvBindByName(column = "휴대폰")
    private String phone;

    public Person toEntity() {
        return new Person(name, phone);
    }

}
