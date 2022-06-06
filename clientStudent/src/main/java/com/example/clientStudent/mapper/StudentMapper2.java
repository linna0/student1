package com.example.clientStudent.mapper;

import com.example.clientStudent.entity.Student;
import com.example.clientStudent.entity.studyScore;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper2 {
    //查询所有学生
    List<Student> selectAll();
    //根据id查询
    Student getStudentById(int s_id);
    //根据id删除学生
    int deleteStudentById(int s_id);
    //成绩表有无学号为
    int scoreByNumberCount(int s_no);
    int deleteStudentById2(int s_id);
    //增加学生
    int addStudent(Student student);
    //根据id修改学生信息
    int modifyStudentById(Student student);

    //根据账号查询
    Student getStudentByNumber(String s_number);

    //查询账号是否存在
    int getNumberExistOrNot(String s_number);

    List<studyScore> getScoreList(int s_no, int c_semaster, int currentPageNo, int pageSize);

    int getScoreCount(int s_no,int c_semaster);

    int getStudentCount(@Param("s_number")String s_number,@Param("s_name")String s_name);

    List<Student> getStudentList(@Param("s_number")String s_number,@Param("s_name")String s_name,@Param("currentPageNo")int currentPageNo, @Param("pageSize")int pageSize);
}
