package com.example.clientStudent.controller;

import com.example.clientStudent.entity.Teacher;
import com.example.clientStudent.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author:yln
 * @create:2022-05-28
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;
    @PostMapping("/login")
    public Teacher selectByN(@RequestParam("t_no") int t_no,@RequestParam("t_name") String t_name){
        return teacherMapper.selectByN(t_no,t_name);
    }
    @PostMapping("/register")
    public int register(@RequestBody Teacher teacher){
        System.out.println("你好呀");
        System.out.println(teacher);
        if(teacher!=null)
        {return teacherMapper.register(teacher);}
        else
            return 0;
    }
}

