package com.sl.mybatis.mapper;

import com.sl.mybatis.entity.Teacher;

import java.util.List;

public interface TeacherMapper {
    /**
     *
     * @return List<Teacher>
     */
    List<Teacher> selectAll();
}