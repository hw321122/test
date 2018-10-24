package com.example.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test.entity.Person;
import com.example.test.mapper.PersonMapper;
import com.example.test.service.TestService;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service("TestService")
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> getDataList() {

        return  personMapper.getPersonList();
    }

    @Override
    public Person selectByPersonId(String id) {
        System.out.println("==select==");
        return personMapper.selectByPersonId(id);
    }

    @Override
    public int insert(Person person) {
        System.out.println("==insert==");
        return personMapper.insert(person);
    }

    @Override
    public int update(Person person) {
        System.out.println("==update==");
        return personMapper.update(person);
    }

    @Override
    public int delete(Person person) {
        return personMapper.delete(person);
    }
}
