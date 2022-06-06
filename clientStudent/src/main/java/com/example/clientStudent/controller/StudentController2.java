package com.example.clientStudent.controller;


import com.example.clientStudent.entity.Student;
import com.example.clientStudent.entity.studyScore;
import com.example.clientStudent.mapper.StudentMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController2 {

    @Autowired
    private StudentMapper2 studentMapper;
    @GetMapping("/selectAll")
    public List<Student> selectAll(){
        return studentMapper.selectAll();
    }

//    @GetMapping("/deleteStudentById")
    @RequestMapping(value = "/deleteStudentById",method = RequestMethod.POST)
    int deleteStudentById(@RequestBody int s_id){
        if(studentMapper.scoreByNumberCount(s_id)!=0)
            return studentMapper.deleteStudentById(s_id);
        else
            return studentMapper.deleteStudentById2(s_id);
    }

//    @GetMapping("/getStudentById")
    @RequestMapping(value = "/getStudentById",method = RequestMethod.POST)
    Student getStudentById(@RequestBody int s_id){
        return studentMapper.getStudentById(s_id);
    }


//    @PostMapping("/addStudent")
    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    int addStudent(@RequestBody Student student){
        System.out.println("Provider:"+student);
        return  studentMapper.addStudent(student);
    }

//    @GetMapping("/modifyStudentById")
    @RequestMapping(value = "/modifyStudentById",method = RequestMethod.POST)
    int modifyStudentById(@RequestBody Student student){
        return  studentMapper.modifyStudentById(student);
    }

    @RequestMapping(value = "/getStudentByNumber",method = RequestMethod.POST)
    Student getStudentByNumber(@RequestBody String s_number){
        return studentMapper.getStudentByNumber(s_number);
    }

    @RequestMapping(value = "/getNumberExistOrNot",method = RequestMethod.POST)
    int getNumberExistOrNot(@RequestBody String s_number){
        return studentMapper.getNumberExistOrNot(s_number);
    }

    @RequestMapping(value = "/getScoreList",method = RequestMethod.POST)
    List<studyScore> getScoreList(@RequestParam("s_no") int s_no, @RequestBody  int c_semaster, @RequestParam("currentPageNo") int currentPageNo,
                                  @RequestParam("pageSize") int pageSize){
        return studentMapper.getScoreList(s_no,c_semaster,currentPageNo,pageSize);
    }

    @RequestMapping(value = "/getScoreCount",method = RequestMethod.POST)
    int getScoreCount(@RequestParam("s_no") int s_no, @RequestBody  int c_semaster){
        return studentMapper.getScoreCount(s_no,c_semaster);
    }

    @RequestMapping(value = "/getStudentCount",method = RequestMethod.POST)
    int getStudentCount( @RequestParam("s_number")  String s_number,@RequestParam("s_name")String s_name){
        System.out.println("getCount----ID:"+",number:"+s_number+",Name:"+s_name);
        return studentMapper.getStudentCount(s_number,s_name);
    }

    @RequestMapping(value = "/getStudentList",method = RequestMethod.POST)
    List<Student> getStudentList(@RequestParam("s_number")  String s_number,
    @RequestParam("s_name")String s_name,@RequestParam("currentPageNo") int currentPageNo,
                                  @RequestParam("pageSize") int pageSize){
        System.out.println("2.getList----ID:"+",number:"+s_number+",Name:"+s_name);
        return studentMapper.getStudentList(s_number,s_name,currentPageNo,pageSize);
    }
}