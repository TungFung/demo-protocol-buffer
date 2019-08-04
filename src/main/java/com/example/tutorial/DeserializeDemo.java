package com.example.tutorial;

import com.example.tutorial.AddressBookProtos.Person;

import java.io.FileInputStream;
import java.io.InputStream;

public class DeserializeDemo {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("src/main/resources/person");
        Person person = Person.parseFrom(inputStream);
        System.out.println(person);



    }
}
