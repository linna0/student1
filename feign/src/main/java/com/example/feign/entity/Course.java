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
public class Course {
    private String c_no;
    private String c_name;
    private int c_credit;
    private String c_semaster;
    private String c_studyhour;
//    private List<student> students;//一门课有多个学生
//    private List<Scourse>scourses;//一门课有多个成绩，感觉不能在学生里面定义，要不然学生太多课了
}
