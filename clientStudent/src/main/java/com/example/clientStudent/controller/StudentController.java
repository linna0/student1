package com.example.clientStudent.controller;

import com.example.clientStudent.entity.Scourse;
import com.example.clientStudent.entity.Student;
import com.example.clientStudent.entity.Teacher;
import com.example.clientStudent.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;
    @RequestMapping("/selectById")
    public List<Teacher> selectById(@RequestParam("t_name") String t_name,@RequestParam("s_id") int id){
        return studentMapper.selectById(t_name,id);
    }
    @RequestMapping("/selectByIdAndCourse")
    public Scourse selectByIdAndCourse(@RequestParam("s_no") int s_no,@RequestParam("c_no") String c_no){
        return studentMapper.selectByIdAndCourse(s_no,c_no);
    }
    @RequestMapping("/updateStudent")
    public int updateStudent(@RequestBody Scourse scourse){
        return studentMapper.updateStudent(scourse);
    }
    @RequestMapping("/insertScore")
    public int insertScore(@RequestBody Scourse scourse){
        return studentMapper.insertScore(scourse);
    }
    @RequestMapping("/selectScore")
    public List<Teacher> selectScore(@RequestParam String t_name){//虽然说只有一个老师，但是这个老师可以查询到很多学生
//        Field field = null;//判断s_id的类型
//        try {
//            field = Student.class.getDeclaredField("s_id");
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
// 获取属性的类型
        return studentMapper.selectScore(t_name);
    }
}