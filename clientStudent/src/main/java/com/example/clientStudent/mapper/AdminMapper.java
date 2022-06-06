package com.example.clientStudent.mapper;

import com.example.clientStudent.entity.Scourse;
import com.example.clientStudent.entity.Student;
import com.example.clientStudent.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:yln
 * @create:2022-06-04
 */
@Repository
public interface AdminMapper {
    List<Student> AdminSelectStudent();
    int AdminUpdateStudent(Student student);
    int AdminDeleteStudent(int s_id);
    int AdminInsertStudent(Student student);
    List<Student> AdminSelectStudentById(int s_id);
    List<Teacher> AdminSelectTeacher();
    int AdminUpdateTeacher(Teacher teacher);
    int AdminDeleteTeacher(int t_no);
    int AdminInsertTeacher(Teacher teacher);
    List<Teacher> AdminSelectTeacherById(int t_no);


//    对学生的成绩操作
List<Teacher> selectById(int s_id);
    Scourse selectByIdAndCourse(int s_no, String c_no);
    //    List<Student> selectAll();
    int updateStudent(Scourse scourse);
    int insertScore(Scourse scourse);//教师端，插入学生的成绩，因为教师没有权限，所以只能插入学生的成绩，没有学生的其他信息
    List<Teacher> selectScore();
    int deleteScore(Scourse scourse);
}
