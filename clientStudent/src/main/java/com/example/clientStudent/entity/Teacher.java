package com.example.clientStudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author:yln
 * @create:2022-05-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int t_no;
    private String t_name;
    private String t_gender;
    private String t_department;
    private String t_job;
    private String t_lecturenumber;
    private Course courses;//一个老师只有一门课,一个课程有多个学生，一个课程有多个分数
    private List<Scourse> scourses;//一个老师里面有多个学生的成绩
    private List<Student> students;//一个老师有多个学生
//    private Scourse scourses;
//    private Student students;
}
