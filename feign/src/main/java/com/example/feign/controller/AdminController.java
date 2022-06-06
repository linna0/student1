package com.example.feign.controller;

import com.example.feign.entity.Scourse;
import com.example.feign.entity.Teacher;
import com.example.feign.entity.student;
import com.example.feign.feign.FeignProviderClient;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:yln
 * @create:2022-06-04
 */
@Controller
@RequestMapping("/feign")
public class AdminController {
    @Autowired
    private FeignProviderClient adminFeign;
    @RequestMapping("/Aselectstudent")
        public ModelAndView AdminSelectStudent(){
            List<student> student= adminFeign.AdminSelectStudent();
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("student",student);
            modelAndView.setViewName("AallStudent");
            return modelAndView;
        }
    @RequestMapping("/AselectstudentById")
    public ModelAndView AdminSelectStudent(@RequestParam("s_id") int s_id){
        List<student> student= adminFeign.AdminSelectStudentById(s_id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("student",student);
        modelAndView.setViewName("AallStudent");
        return modelAndView;
    }
    @RequestMapping("/Aselectteacher")
    public ModelAndView AdminSelectTeacher(){
        List<Teacher> teachers= adminFeign.AdminSelectTeacher();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("teacher",teachers);
        modelAndView.setViewName("AallTeacher");
        return modelAndView;
    }
    @RequestMapping("/AselectteacherById")
    public ModelAndView AdminSelectTeacher(@RequestParam("t_no") int t_no){
        List<Teacher> teacher= adminFeign.AdminSelectTeacherById(t_no);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("teacher",teacher);
        modelAndView.setViewName("AallTeacher");
        return modelAndView;
    }
    @RequestMapping("/delTeacher/{t_no}")
    public String deleteTeacher(@PathVariable("t_no") int t_no){
        int i=adminFeign.AdminDeleteTeacher(t_no);
        return "redirect:/feign/Aselectteacher";
    }
    @RequestMapping("/delStudent/{s_id}")
    public String deleteStudent(@PathVariable("s_id") int s_id){
        adminFeign.AdminDeleteStudent(s_id);
        return "redirect:/feign/Aselectstudent";
    }
    @RequestMapping("/toalertTeacher/{t_no}")
    public String alertTeacher(@PathVariable("t_no") int t_no,Model model){
        List<Teacher> teachers=adminFeign.AdminSelectTeacherById(t_no);
        model.addAttribute("teachers",teachers);
        return "alertTeacher";
    }
    @RequestMapping("/alertTeacher")
    public String alertTeacher(Model model,Teacher teacher){
        int a=adminFeign.AdminUpdateTeacher(teacher);
        System.out.println(a);
        return "redirect:/feign/Aselectteacher";
    }
    @RequestMapping("/toalertStudent/{s_id}")
    public String alertStudent(@PathVariable("s_id") int s_id,Model model){
        List<student> students=adminFeign.AdminSelectStudentById(s_id);
        model.addAttribute("students",students);
        return "alertStudent";
    }
    @RequestMapping("/alertStudent")
    public String alertStudent(Model model,student student){
        int a=adminFeign.AdminUpdateStudent(student);
        System.out.println(a);
        return "redirect:/feign/Aselectstudent";
    }
    @RequestMapping("/toAddTeacher")
    public String toaddTeacher(){
        return "AddTeacher";
    }
    @RequestMapping("AddTeacher")
    public String addTeacher(Teacher teacher){
        adminFeign.AdminInsertTeacher(teacher);
        return "redirect:/feign/Aselectteacher";
    }
    @RequestMapping("/toAddStudent")
    public String toaddStudent(){
        return "AddStudent";
    }
    @RequestMapping("/AddStudent")
    public String addStudent(student student){
        adminFeign.AdminInsertStudent(student);
        return "redirect:/feign/Aselectstudent";
    }


//    对学生成绩管理
    @RequestMapping("/allScore")
    public ModelAndView selectScore(){
        List<Teacher> collection = adminFeign.selectScore1();//这里装的是一整个teacher对象
        System.out.println(collection);
        List s1 = new ArrayList();
        List s2=new ArrayList();
        List<Integer> num1=new ArrayList<>() ;
        List<String> s3=new ArrayList<>();
        int i=0;
        ModelAndView modelAndView = new ModelAndView();
        if (collection.get(0).getStudents().size()==0){
            modelAndView.addObject("error","查询到的学生为空");
            modelAndView.setViewName("error");
        }
        System.out.println(collection.get(0).getStudents().size());
        for (int j=0;j<collection.size();j++){
        for(i=0;i<collection.get(j).getStudents().size();i++) {
            s1.add(collection.get(j).getT_name());
            s1.add(collection.get(j).getCourses().getC_no());
            s3.add(collection.get(j).getCourses().getC_no());
            s1.add(collection.get(j).getCourses().getC_name());
            s1.add(collection.get(j).getCourses().getC_credit());
            s1.add(collection.get(j).getCourses().getC_semaster());
            s1.add(collection.get(j).getCourses().getC_studyhour());
            s1.add(collection.get(j).getStudents().get(i).getS_id());
            num1.add(collection.get(j).getStudents().get(i).getS_id());
            s1.add(collection.get(j).getStudents().get(i).getS_name());
            s1.add(collection.get(j).getScourses().get(i).getC_score());
            s2.addAll(s1);
            s1.clear();
        }}
        modelAndView.addObject("collection", collection);
        modelAndView.addObject("s3", s3);
        modelAndView.addObject("num1",num1);
        modelAndView.addObject("s2",s2);
        System.out.println(s2);
        modelAndView.setViewName("allStudent");
        return modelAndView;
    }
    @RequestMapping("/allScoreById")
    public  ModelAndView selectById(@RequestParam("s_id")int s_id){
        List<Teacher> collection = adminFeign.selectById1(s_id);//这里装的是一整个teacher对象
        List s1 = new ArrayList();
        List s2=new ArrayList();
        List<Integer> num1=new ArrayList<>() ;
        List<String> s3=new ArrayList<>();
        int i=0;
        ModelAndView modelAndView = new ModelAndView();
        if (collection.get(0).getStudents().size()==0){
            modelAndView.addObject("error","查询到的学生为空");
            modelAndView.setViewName("error");
        }
        for (int j=0;j<collection.size();j++){
            for(i=0;i<collection.get(j).getStudents().size();i++) {
                s1.add(collection.get(j).getT_name());
                s1.add(collection.get(j).getCourses().getC_no());
                s3.add(collection.get(j).getCourses().getC_no());
                s1.add(collection.get(j).getCourses().getC_name());
                s1.add(collection.get(j).getCourses().getC_credit());
                s1.add(collection.get(j).getCourses().getC_semaster());
                s1.add(collection.get(j).getCourses().getC_studyhour());
                s1.add(collection.get(j).getStudents().get(i).getS_id());
                num1.add(collection.get(j).getStudents().get(i).getS_id());
                s1.add(collection.get(j).getStudents().get(i).getS_name());
                s1.add(collection.get(j).getScourses().get(i).getC_score());
                s2.addAll(s1);
                s1.clear();
            }}
        modelAndView.addObject("collection", collection);
        modelAndView.addObject("s3", s3);
        modelAndView.addObject("num1",num1);
        modelAndView.addObject("s2",s2);
        modelAndView.setViewName("allStudent");
        return modelAndView;
    }
    @RequestMapping("/toupdateStudent1")//跳转到修改学生的页面
    public String toupdateStudent(Model model,@RequestParam("s_no") int s_no,@RequestParam("c_no")String c_no){
        Scourse students=adminFeign.selectByIdAndCourse1(s_no,c_no);//应该在点击的时候就获取课程号
        model.addAttribute("students",students);
        return "AdminUpdateStudent";
    }
    @RequestMapping("/updateStudent1")
    public String updateStudent(Scourse scourse, HttpServletResponse response)throws IOException {
        int a=adminFeign.updateStudent(scourse);
        if(a!=0)
            return "redirect:/feign/allScore";
        else
        {response.getWriter().write("<script>alert('error,id is wrong');window.location='/feign/toupdateStudent1'</script>");
            return null;}
    }
    @RequestMapping("insertStudent1.html")//跳转到插入学生的页面
    public String toinsertStudent(){
        return "AdminInsertStudent";
    }
    @RequestMapping("/insertScore1")//插入学生的成绩
    public String insertScore(Scourse scourse,HttpServletResponse response) throws IOException {
        int m=adminFeign.insertScore1(scourse);
        if(m!=0)
            return "redirect:/feign/allScore";
        else
        {
            response.getWriter().write("<script>alert('error,id is wrong');window.location='/feign/insertStudent1.html'</script>");
            return null;
        }
    }
    @RequestMapping("/deleteScore")
    public String deleteScore(@RequestParam("s_no") int s_no,@RequestParam("c_no")String c_no){
        Scourse scourse= adminFeign.selectByIdAndCourse1(s_no,c_no);
//        Scourse scourse=new Scourse();
//        scourse.setC_score(teachers.getScourses().get(0).getC_score());
//        scourse.setC_no(teachers.getScourses().get(0).getC_no());
//        scourse.setS_no(s_no);
        System.out.println("hello"+scourse);
        adminFeign.deleteScore(scourse);
        return "redirect:/feign/allScore";
    }
    @RequestMapping("/index.html")
    public String toindex(){
        return "indexindex";
    }

}
