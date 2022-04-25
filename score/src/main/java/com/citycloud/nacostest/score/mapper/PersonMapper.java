package com.citycloud.nacostest.score.mapper;

import com.citycloud.nacostest.score.entity.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 孟帅
 * @since 2022/4/25
 */
@Mapper
public interface PersonMapper {
    /**
     * 获取所有人信息
     *
     * @return .
     */
    List<Person> getPersons();
}
