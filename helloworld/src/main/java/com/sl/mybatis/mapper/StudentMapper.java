package com.sl.mybatis.mapper;

import com.sl.mybatis.entity.Student;

import java.util.List;

public interface StudentMapper {
    /**
     *
     * @return List<Student>
     */
    List<Student> selectAll();
}