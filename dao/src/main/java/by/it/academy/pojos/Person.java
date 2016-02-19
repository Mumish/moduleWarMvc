/*
 * Copyright (c) 2012 by VeriFone, Inc.
 * All Rights Reserved.
 *
 * THIS FILE CONTAINS PROPRIETARY AND CONFIDENTIAL INFORMATION
 * AND REMAINS THE UNPUBLISHED PROPERTY OF VERIFONE, INC.
 *
 * Use, disclosure, or reproduction is prohibited
 * without prior written approval from VeriFone, Inc.
 */
package by.it.academy.pojos;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import javax.persistence.*;

/**
 * User: yslabko
 * Date: 14.04.14
 * Time: 12:24
 */
@Entity
public class Person {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "AGE")
    @DecimalMax(value = "150", message = "Digit must be a less than 150")
    @DecimalMin(value = "0", message = "Digit must be a greater than 0")
    private Integer age;
    
    @Column(name = "NAME")
    @Pattern(regexp="^[A-Z]+[a-z]+$", message="Username must be alphanumeric with no spaces and first capital")
    private String name;
    
    @Column(name = "SURNAME")
    private String surname;

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (age != null ? !age.equals(person.age) : person.age != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return surname != null ? surname.equals(person.surname) : person.surname == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Person : id: " + id + " Name: " + name + " Surname: " + surname + " Age: " +age;// + personAddress;
    }
}
