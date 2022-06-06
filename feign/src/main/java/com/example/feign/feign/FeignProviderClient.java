package com.example.feign.feign;


import com.example.feign.entity.Scourse;
import com.example.feign.entity.Teacher;
import com.example.feign.entity.student;
import com.example.feign.entity.studyScore;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@FeignClient(value = "provider")
public interface FeignProviderClient {

//    @GetMapping("/student/selectall")
//    List<student> selectAll();
    @RequestMapping(value = "/teacher/register",method = RequestMethod.POST)
    int register(@RequestBody Teacher teacher);
    @PostMapping("/teacher/login")
    Teacher login(@RequestParam("t_no") int t_no,@RequestParam("t_name") String t_name) throws DataAccessException;
    @PostMapping("/student/selectById")
    List<Teacher> selectById(@RequestParam("t_name")String t_name,@RequestParam("s_id") int s_id);
    @PostMapping("/student/selectByIdAndCourse")
    Scourse selectByIdAndCourse(@RequestParam("s_no")int s_no,@RequestParam("c_no")String c_no);
    @RequestMapping("/student/updateStudent")
    int updateStudent(Scourse scourse);
    @RequestMapping("/student/insertScore")
    int insertScore(Scourse scourse);
    @RequestMapping("/student/selectScore")
    List<Teacher> selectScore(@RequestParam String t_name);



    @RequestMapping("/admin/AselectStudent")
    List<student> AdminSelectStudent();
    @RequestMapping("/admin/AupdateStudent")
    int AdminUpdateStudent(@RequestBody student student);
    @RequestMapping("/admin/AdeleteStudent")
    int AdminDeleteStudent(@RequestParam("s_id") int s_id);
    @RequestMapping("/admin/AinsertStudent")
    int AdminInsertStudent(student student);
    @RequestMapping("/admin/AselectStudentById")
    List<student> AdminSelectStudentById(@RequestParam("s_id") int s_id);
    @RequestMapping("/admin/AselectTeacher")
    List<Teacher> AdminSelectTeacher();
    @RequestMapping("/admin/AupdateTeacher")
    int AdminUpdateTeacher(Teacher teacher);
    @RequestMapping("/admin/AdeleteTeacher")
    int AdminDeleteTeacher(@RequestParam("t_no") int t_no);
    @RequestMapping("/admin/AinsertTeacher")
    int AdminInsertTeacher(Teacher teacher);
    @RequestMapping("/admin/AselectTeacherById")
    List<Teacher> AdminSelectTeacherById(@RequestParam("t_no") int t_no);


    //管理员对学生表操作

    @PostMapping("/admin/selectById")
    List<Teacher> selectById1(@RequestParam("s_no") int s_no);
    @PostMapping("/admin/selectByIdAndCourse")
    Scourse selectByIdAndCourse1(@RequestParam("s_no")int s_no,@RequestParam("c_no")String c_no);
    @RequestMapping("/admin/updateStudent")
    int updateStudent1(Scourse scourse);
    @RequestMapping("/admin/insertScore")
    int insertScore1(Scourse scourse);
    @RequestMapping("/admin/selectScore")
    List<Teacher> selectScore1();
    @RequestMapping("/admin/deleteScore")
    int deleteScore(Scourse scourse);


    //学生操作
    @GetMapping("/student/selectAll")
    List<student> selectAll();

    @RequestMapping(value = "/student/deleteStudentById",method = RequestMethod.POST)
    int deleteStudentById(@RequestBody int s_id);

    //    @GetMapping("/student/getStudentById")
    @RequestMapping(value = "/student/getStudentById",method = RequestMethod.POST)
    student getStudentById(@RequestBody int s_id);

    @RequestMapping(value = "/student/addStudent",method = RequestMethod.POST)
    int addStudent(@RequestBody student student);

    @RequestMapping(value = "/student/modifyStudentById",method = RequestMethod.POST)
//    @GetMapping("/student/modifyStudentById")
    int modifyStudentById(@RequestBody student student);

    @RequestMapping(value = "/student/getStudentByNumber",method = RequestMethod.POST)
    student getStudentByNumber(@RequestBody String s_number);

    @RequestMapping(value = "/student/getNumberExistOrNot",method = RequestMethod.POST)
    int getNumberExistOrNot(@RequestBody String s_number);

    @RequestMapping(value = "/student/getScoreList",method = RequestMethod.POST)
    List<studyScore> getScoreList(@RequestParam("s_no") int s_no, @RequestBody  int c_semaster,
                                  @RequestParam("currentPageNo") int currentPageNo,
                                  @RequestParam("pageSize") int pageSize);

    @RequestMapping(value = "/student/getScoreCount",method = RequestMethod.POST)
    int getScoreCount(@RequestParam("s_no") int s_no, @RequestBody  int c_semaster);

    @RequestMapping(value = "/student/getStudentCount",method = RequestMethod.POST)
    int getStudentCount( @RequestParam("s_number")   String s_number,@RequestParam("s_name")String s_name);

    @RequestMapping(value = "/student/getStudentList",method = RequestMethod.POST)
    List<student> getStudentList(@RequestParam("s_number")  String s_number,
                                 @RequestParam("s_name")String s_name,@RequestParam("currentPageNo") int currentPageNo,
                                 @RequestParam("pageSize") int pageSize);
}
