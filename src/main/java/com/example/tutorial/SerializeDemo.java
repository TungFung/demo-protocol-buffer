package com.example.tutorial;

import com.example.tutorial.AddressBookProtos.Person;
import com.example.tutorial.AddressBookProtos.Person.PhoneNumber;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializeDemo {

    public static void main(String[] args) throws Exception {
        PhoneNumber phoneNumber = Person.PhoneNumber.newBuilder()
                                                .setNumber("555-4321")
                                                .setType(Person.PhoneType.HOME)
                                                .build();
        Person person = Person.newBuilder()
                    .setId(1234)
                    .setName("John Doe")
                    .setEmail("jdoe@example.com")
                    .addPhones(phoneNumber)
                    .build();

        OutputStream outputStream = new FileOutputStream("src/main/resources/person"); //文件后缀没有关系
        person.writeTo(outputStream);

        /** 这里如果用ObjectOutputStream write出去的话，反序列化会报错,需要用Protocol Buffer自身的writeTo方法 **/
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        objectOutputStream.write(person.toByteArray());
//        objectOutputStream.flush();
//        objectOutputStream.close();

    }
}
