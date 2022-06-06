package com.example.clientStudent.controller;

import com.example.clientStudent.entity.Scourse;
import com.example.clientStudent.entity.Student;
import com.example.clientStudent.entity.Teacher;
import com.example.clientStudent.mapper.AdminMapper;
import com.example.clientStudent.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:yln
 * @create:2022-06-04
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;
@RequestMapping("/AselectStudent")
    List<Student> AdminSelectStudent(){
    return adminMapper.AdminSelectStudent();
}
@RequestMapping("/AupdateStudent")
    int AdminUpdateStudent(@RequestBody Student student){
    return adminMapper.AdminUpdateStudent(student);
    }
    @RequestMapping("/AdeleteStudent")
    int AdminDeleteStudent(@RequestParam("s_id") int s_id){
    return adminMapper.AdminDeleteStudent(s_id);
    }
    @RequestMapping("/AinsertStudent")
    int AdminInsertStudent(@RequestBody Student student){
    return adminMapper.AdminInsertStudent(student);
    }
    @RequestMapping("/AselectStudentById")
    List<Student> AdminSelectStudentById(@RequestParam("s_id") int s_id){
    return adminMapper.AdminSelectStudentById(s_id);
    }
    @RequestMapping("/AselectTeacher")
    List<Teacher> AdminSelectTeacher(){
    return adminMapper.AdminSelectTeacher();
    }
    @RequestMapping("/AupdateTeacher")
    int AdminUpdateTeacher(@RequestBody Teacher teacher){
    return adminMapper.AdminUpdateTeacher(teacher);
    }
    @RequestMapping("/AdeleteTeacher")
    int AdminDeleteTeacher(@RequestParam("t_no") int t_no){
    return adminMapper.AdminDeleteTeacher(t_no);
    }
    @RequestMapping("/AinsertTeacher")
    int AdminInsertTeacher(@RequestBody Teacher teacher){
    return adminMapper.AdminInsertTeacher(teacher);
    }
    @RequestMapping("/AselectTeacherById")
    List<Teacher> AdminSelectTeacherById(@RequestParam("t_no") int t_no){
    return adminMapper.AdminSelectTeacherById(t_no);
    }


    @RequestMapping("/selectById")
    public List<Teacher> selectById(@RequestParam("s_no") int id){
        return adminMapper.selectById(id);
    }
    @RequestMapping("/selectByIdAndCourse")
    public Scourse selectByIdAndCourse(@RequestParam("s_no") int s_no, @RequestParam("c_no") String c_no){
        return adminMapper.selectByIdAndCourse(s_no,c_no);
    }
    @RequestMapping("/updateStudent")
    public int updateStudent(@RequestBody Scourse scourse){
        return adminMapper.updateStudent(scourse);
    }
    @RequestMapping("/insertScore")
    public int insertScore(@RequestBody Scourse scourse){
        return adminMapper.insertScore(scourse);
    }
    @RequestMapping("/selectScore")
    public List<Teacher> selectScore(){//虽然说只有一个老师，但是这个老师可以查询到很多学生
        System.out.println(adminMapper.selectScore());
        return adminMapper.selectScore();
    }
    @RequestMapping("/deleteScore")
    public int deleteScoure(@RequestBody Scourse scourse){
    return adminMapper.deleteScore(scourse);
    }
}
