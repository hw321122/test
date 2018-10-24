package com.example.test.mapper;



import com.example.test.entity.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {
    List<Person> getPersonList();
    Person selectByPersonId(String id);
    int update(Person person);
    int insert(Person person);
    int delete(Person person);
}
