package com.example.test.service;

import com.example.test.entity.Person;

import java.util.List;

public interface TestService {
    public List<Person> getDataList();
    public Person selectByPersonId(String id);
    public int insert(Person person);
    public int update(Person person);
    public int delete(Person person);
}
