package com.example.feign.controller;

import com.example.feign.entity.Scourse;
import com.example.feign.entity.Teacher;
import com.example.feign.feign.FeignProviderClient;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/feign")
public class FeignController {

    String cno= new String("计算机操作");//这里设置了课程，但其实这样是不好的
    String name="村长";//全局变量，存放老师的名字
    @Autowired
    private FeignProviderClient feignProviderClient;

//    @RequestMapping("/selectall")
//    public  ModelAndView selectAll(){
//        List<student> collection = feignProviderClient.selectAll();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("collection", collection);
//        modelAndView.setViewName("allUser");
//        return modelAndView;
//    }
//    @RequestMapping("/selectById")
//    public  ModelAndView selectById(@RequestParam("s_id")int s_id){
//        List<student> collection = feignProviderClient.selectById(name,s_id);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("collection", collection);
//        modelAndView.setViewName("allUser");
//        return modelAndView;
//    }
@RequestMapping("/selectById")//根据id查找学生，这里跟查询全部是一样的
public  ModelAndView selectById(@RequestParam("s_id")int s_id){
    List<Teacher> collection = feignProviderClient.selectById(name,s_id);//这里装的是一整个teacher对象
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
    for(i=0;i<collection.get(0).getStudents().size();i++) {
        s1.add(collection.get(0).getT_name());
        s1.add(collection.get(0).getCourses().getC_no());
        s3.add(collection.get(0).getCourses().getC_no());
        s1.add(collection.get(0).getCourses().getC_name());
        s1.add(collection.get(0).getCourses().getC_credit());
        s1.add(collection.get(0).getCourses().getC_semaster());
        s1.add(collection.get(0).getCourses().getC_studyhour());
        s1.add(collection.get(0).getStudents().get(i).getS_id());
        num1.add(collection.get(0).getStudents().get(i).getS_id());
        s1.add(collection.get(0).getStudents().get(i).getS_name());
        s1.add(collection.get(0).getScourses().get(i).getC_score());
        s2.addAll(s1);
        s1.clear();
    }

    modelAndView.addObject("collection", collection);
    modelAndView.addObject("s3", s3);
    modelAndView.addObject("num1",num1);
    modelAndView.addObject("s2",s2);
    modelAndView.setViewName("all");
    return modelAndView;
}
    @RequestMapping("/toupdateStudent")//跳转到修改学生的页面
    public String toupdateStudent(Model model,@RequestParam("s_no") int s_no){
        Scourse students=feignProviderClient.selectByIdAndCourse(s_no,cno);
        model.addAttribute("students",students);
        return "UpdateStudent";
    }
    @RequestMapping("/updateStudent")
    public String updateStudent(Scourse scourse,HttpServletResponse response)throws IOException {
        int a=feignProviderClient.updateStudent(scourse);
        if(a!=0)
            return "redirect:/feign/selectScore";
        else
        {response.getWriter().write("<script>alert('error,id is wrong');window.location='/feign/toupdateStudent'</script>");
        return null;}
    }
    @RequestMapping("insertStudent.html")//跳转到插入学生的页面
    public String toinsertStudent(){
        return "InsertStudent";
    }
    @RequestMapping("insertScore")//插入学生的成绩
    public String insertScore(Scourse scourse,HttpServletResponse response) throws IOException {
        int m=feignProviderClient.insertScore(scourse);
        if(m!=0)
            return "redirect:/feign/selectScore";
        else
        {
            response.getWriter().write("<script>alert('error,id is wrong');window.location='/feign/insertStudent.html'</script>");
            return null;
        }
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(Teacher t,HttpServletResponse response) throws IOException {
        int m=feignProviderClient.register(t);
        System.out.println("你好呀");
        if(m!=0){
        return "login";}
        else
        {
            response.getWriter().write("<script>alert('error,id is wrong');window.location='/feign/register.html'</script>");
            return null;
        }

    }
    @GetMapping("register.html")//老师注册
    public String toregister(){
        return "register";
    }
    @GetMapping("login.html")
    public String tologin(){
        System.out.println("你好呀");
    return "login";
    }

    @PostMapping("/login")//老师登录
    public String login(@RequestParam("t_no") int t_no,@RequestParam("t_name") String t_name, HttpServletResponse response) throws IOException {

    Teacher teacher=feignProviderClient.login(t_no,t_name);
        if (teacher!=null){
            name=t_name;
            cno=teacher.getT_lecturenumber();
            return "redirect:/feign/selectScore";}
        else
        {
            response.getWriter().write("<script>alert('错误,id is wrong');window.location='/feign/login.html'</script>");
            return null;}
    }
    @RequestMapping("tosocket")
    public ModelAndView toindex(){
    ModelAndView modelAndView=new ModelAndView();
    modelAndView.addObject("name",name);
    modelAndView.setViewName("index");
    return modelAndView;
}
    @RequestMapping("/selectScore")//老师登录之后的界面，感觉写的负责了一些，这里是和根据id查询时一样的
    public ModelAndView selectScore(){
        List<Teacher> collection = feignProviderClient.selectScore(name);//这里装的是一整个teacher对象
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
        for(i=0;i<collection.get(0).getStudents().size();i++) {
            s1.add(collection.get(0).getT_name());
            s1.add(collection.get(0).getCourses().getC_no());
            s3.add(collection.get(0).getCourses().getC_no());
            s1.add(collection.get(0).getCourses().getC_name());
            s1.add(collection.get(0).getCourses().getC_credit());
            s1.add(collection.get(0).getCourses().getC_semaster());
            s1.add(collection.get(0).getCourses().getC_studyhour());
            s1.add(collection.get(0).getStudents().get(i).getS_id());
            num1.add(collection.get(0).getStudents().get(i).getS_id());
            s1.add(collection.get(0).getStudents().get(i).getS_name());
            s1.add(collection.get(0).getScourses().get(i).getC_score());
            s2.addAll(s1);
            s1.clear();
        }
        modelAndView.addObject("collection", collection);
        modelAndView.addObject("s3", s3);
        modelAndView.addObject("num1",num1);
        modelAndView.addObject("s2",s2);
        modelAndView.setViewName("all");
        return modelAndView;
    }
}
