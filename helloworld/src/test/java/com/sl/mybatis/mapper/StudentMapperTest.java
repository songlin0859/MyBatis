package com.sl.mybatis.mapper;

import com.sl.mybatis.entity.Student;
import com.sl.mybatis.entity.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Homejim
 * Date 2018-9-4
 * Time 20:40
 */
public class StudentMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIf(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            /*List<Student> students = studentMapper.testIf(null);
            for (Student student : students) {
                System.out.println(student);
            }*/

            List<Student> students = studentMapper.testIf("小丽");
            System.out.println("=========================");
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void getTeacher(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<Teacher> teachers = sqlSession.selectList("com.sl.mybatis.mapper.TeacherMapper.selectAll");
            for (Teacher teacher : teachers) {
                System.out.println(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void testSelectList() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<Student> students = sqlSession.selectList("com.sl.mybatis.mapper.StudentMapper.selectAll");
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}