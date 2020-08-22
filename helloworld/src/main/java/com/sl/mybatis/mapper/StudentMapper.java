package com.sl.mybatis.mapper;

import com.sl.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /**
     *
     * @return List<Student>
     */
    List<Student> selectAll();

    List<Student> testIf(String name);
    //mapper里的接口参数是多个，加上@Param注解
    List<Student> testChoose(@Param("name") String name, @Param("sex") Integer sex);
}