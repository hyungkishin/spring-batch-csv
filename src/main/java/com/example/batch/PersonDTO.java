package com.example.batch;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;

@Getter
public class PersonDTO {
    @CsvBindByName(column = "이름")
    private String name;

    @CsvBindByName(column = "휴대폰")
    private String phone;

    public Person toEntity() {
        return new Person(name, phone);
    }

}
