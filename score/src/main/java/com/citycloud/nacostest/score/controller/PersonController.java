package com.citycloud.nacostest.score.controller;

import com.citycloud.nacostest.score.entity.Person;
import com.citycloud.nacostest.score.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 孟帅
 * @since 2022/4/25
 */
@RestController
@RequestMapping("/personController")
@RefreshScope
public class PersonController {
    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/getPersons")
    public List<Person> getPersons() {
        return personMapper.getPersons();
    }
}
