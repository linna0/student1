package com.example.clientStudent.mapper;

import com.example.clientStudent.entity.Scourse;
import com.example.clientStudent.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:yln
 * @create:2022-05-28
 */
@Repository
public interface StudentMapper {
    List<Teacher> selectById(String t_name,int s_id);
    Scourse selectByIdAndCourse(int s_no,String c_no);
//    List<Student> selectAll();
    int updateStudent(Scourse scourse);
    int insertScore(Scourse scourse);//教师端，插入学生的成绩，因为教师没有权限，所以只能插入学生的成绩，没有学生的其他信息
    List<Teacher> selectScore(String t_name);
}
