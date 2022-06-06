package com.example.feign.entity;

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
    private String t_department;
    private String t_job;
    private String t_lecturenumber;
    private String t_gender;
    private Course courses;//一个老师只有一门课
    private List<Scourse> scourses;//一个老师里面有多个学生的成绩
    private List<student> students;//一个老师有多个学生
//private Scourse scourses;
//    private student students;
}
