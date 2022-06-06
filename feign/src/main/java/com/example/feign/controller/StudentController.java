package com.example.feign.controller;

import com.example.feign.entity.student;
import com.example.feign.entity.studyScore;
import com.example.feign.feign.FeignProviderClient;
import com.example.feign.utils.Constants;
import com.example.feign.utils.PageSupport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:yln
 * @create:2022-06-05
 */
@Controller
public class StudentController {
    @Autowired
    private FeignProviderClient feignConsumerClient;
    @Autowired
    private PageSupport pageSupport;
    public  static  String studentName;//记录当前登录学生姓名
    @GetMapping("/feign/selectAllStudent")
    public ModelAndView selectAllStudent(String queryNumber, String queryName,
                                         @RequestParam(value="pageIndex",required=false) String pageIndex){
        ModelAndView modelAndView = new ModelAndView();
        int pageSize = Constants.pageSize; //设置页面容量
        int currentPageNo = 1; //默认当前页码

        if (queryNumber == null) {
            queryNumber = "-1";
        }
        if (queryName == null) {
            queryName= "-1";
        }
        if (pageIndex != null) {
            try {
                currentPageNo = Integer.valueOf(pageIndex);
            } catch (NumberFormatException e) {

                modelAndView.setViewName("/error");
            }
        }

        //按照条件查询的总数量
        int totalCount = feignConsumerClient.getStudentCount(queryNumber,queryName);
        System.out.println("totalCount:"+totalCount);
        pageSupport.setCurrentPageNo(currentPageNo);    //当前页
        pageSupport.setPageSize(pageSize);              //页面大小
        pageSupport.setTotalCount(totalCount);          //总数量
        pageSupport.setTotalPageCountByRs();
        int totalPageCount = pageSupport.getTotalPageCount();  //总页面数量

        //控制首页和尾页
        //如果页面小于第一页，就显示第一页
        if (currentPageNo < 1) {
            currentPageNo = 1;
            //如果当前页面大于最后一页，当前页等于最后一页即可
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        List<student> collection = feignConsumerClient.getStudentList(queryNumber,queryName,(currentPageNo - 1) * pageSize, pageSize);
        modelAndView.addObject("collection", collection);
        if (queryName != "-1") {
            modelAndView.addObject("queryName", queryName);
        }
        if (queryNumber != "-1") {
            modelAndView.addObject("queryNumber", queryNumber);
        }


        modelAndView.addObject("totalPageCount", totalPageCount);
        modelAndView.addObject("totalCount", totalCount);
        modelAndView.addObject("currentPageNo", currentPageNo);
        modelAndView.setViewName("/allStudent2");
        return modelAndView;
    }




    @GetMapping("/feign/selectAll")
    public  ModelAndView selectAll(){
        List<student> collection = feignConsumerClient.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("collection", collection);
        modelAndView.setViewName("/allStudent2");
        return modelAndView;
    }



    @GetMapping("/feign/addStudent")
    public  ModelAndView addStudent(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/addStudent2");
        return modelAndView;
    }

    @PostMapping("/feign/studentAdd")
    public ModelAndView studentAdd(student student){
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("Consumer:"+student);
        if(feignConsumerClient.addStudent(student)==0) {
            modelAndView.setViewName("/addWhetherSuccess");
            modelAndView.addObject("msg", "失败");
        }
        else
        {
            modelAndView.setViewName("/addWhetherSuccess");
            modelAndView.addObject("msg", "成功");
        }

        return modelAndView;
    }

    @GetMapping("/feign/deleteStudent")
    public ModelAndView deleteStudent(String id){
        ModelAndView modelAndView=new ModelAndView();
        if (id!=null) {
            int flag = feignConsumerClient.deleteStudentById(Integer.parseInt(id));
            if (flag > 0) {//删除成功
                modelAndView.setViewName("/addWhetherSuccess");
                modelAndView.addObject("msg", "成功");
            } else if (flag == 0) {//删除失败
                modelAndView.setViewName("/addWhetherSuccess");
                modelAndView.addObject("msg", "失败");
            }
        }
        return modelAndView;
    }

    @GetMapping("/feign/modifyStudent")
    public ModelAndView modifyStudent(String id){
        ModelAndView modelAndView=new ModelAndView();
        student student;
        student = feignConsumerClient.getStudentById(Integer.parseInt(id));
        if(student!=null)
        {
            modelAndView.setViewName("/modifyStudent");
            modelAndView.addObject("student",student);
        }
        else
            modelAndView.setViewName("/allStudent2");
        return modelAndView;
    }
    @PostMapping("/feign/studentModify")
    public ModelAndView studentModify(student student){
        ModelAndView modelAndView=new ModelAndView();
        if(feignConsumerClient.modifyStudentById(student)==0) {
            modelAndView.setViewName("/addWhetherSuccess");
            modelAndView.addObject("msg", "失败");
        }
        else
        {
            modelAndView.setViewName("/addWhetherSuccess");
            modelAndView.addObject("msg", "成功");
        }

        return modelAndView;
    }

    @GetMapping("/feign/viewStudent")
    public ModelAndView viewStudent(String id){
        ModelAndView modelAndView=new ModelAndView();
        student student;
        student = feignConsumerClient.getStudentById(Integer.parseInt(id));
        if(student!=null)
        {
            modelAndView.setViewName("/viewStudent");
            modelAndView.addObject("student",student);
        }
        else
            modelAndView.setViewName("/allStudent2");
        return modelAndView;
    }
    public  static  int studentID;//记录当前登录学生的学号


    @RequestMapping("/feign/Studentlogin")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tologin");
        return modelAndView;
    }

    @RequestMapping("/tosocket")
    public ModelAndView communicate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index2");
        modelAndView.addObject("name",studentName);
        return modelAndView;
    }

    @RequestMapping ("/register.do")
    public  ModelAndView register(student student){

        feignConsumerClient.addStudent(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tologin");
        return modelAndView;
    }

    @RequestMapping("/loginToHome")
    String login(String s_number,String s_id)
    {
        ModelAndView modelAndView = new ModelAndView();
        studentID=Integer.parseInt(s_id);
        System.out.println("1:"+studentID);
        System.out.println("账号："+s_number);
        System.out.println("密码："+s_id);
        if(s_number!=null && feignConsumerClient.getNumberExistOrNot(s_number)!=0)
        {
            student student2=feignConsumerClient.getStudentByNumber(s_number);
            studentName=student2.getS_name();
            System.out.println(student2);
            if(student2.getS_id()==Integer.parseInt(s_id))
//                modelAndView.setViewName("home");
                return "redirect:/feign/getScoreList";
            else
                return "tologin";
        }
        else
            return "tologin";
    }

    @RequestMapping (value="/studentCheck",produces="text/html;charset=UTF-8")
    void studentCheck(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String s_number = req.getParameter("s_number");
        if (s_number != null && !"".equals(s_number)) {
            int nameExist = feignConsumerClient.getNumberExistOrNot(s_number);
            //创建相应键值对
            Map<String, Object> map = new HashMap<>();
            if (nameExist == 0) {
                //不存在
                map.put("studentExist", false);
            } else {
                //存在
                map.put("studentExist", true);
            }
            //使用jackson发送json型数据给页面
            ObjectMapper om = new ObjectMapper();
            om.writeValue(resp.getWriter(), map);
            System.out.println(om);
        }
    }

    @RequestMapping("/feign/getScoreList")
    ModelAndView getGoodsList(String querySemaster,
                              @RequestParam(value="pageIndex",required=false) String pageIndex){
        ModelAndView modelAndView = new ModelAndView();
        int pageSize = Constants.pageSize; //设置页面容量
        int currentPageNo = 1; //默认当前页码
        if (querySemaster == null) {
            querySemaster = "1";
        }
        if (pageIndex != null) {
            try {
                currentPageNo = Integer.valueOf(pageIndex);
            } catch (NumberFormatException e) {
                modelAndView.setViewName("/error");
            }
        }

        //按照条件查询的总数量
        int totalCount = feignConsumerClient.getScoreCount(studentID,Integer.parseInt(querySemaster.trim()));
        pageSupport.setCurrentPageNo(currentPageNo);    //当前页
        pageSupport.setPageSize(pageSize);              //页面大小
        pageSupport.setTotalCount(totalCount);          //总数量
        pageSupport.setTotalPageCountByRs();
        int totalPageCount = pageSupport.getTotalPageCount();  //总页面数量

        //控制首页和尾页
        //如果页面小于第一页，就显示第一页
        if (currentPageNo < 1) {
            currentPageNo = 1;
            //如果当前页面大于最后一页，当前页等于最后一页即可
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        System.out.println("totalpagecount"+totalPageCount);
        System.out.println("totalCount"+totalCount);
        List<studyScore> collection = feignConsumerClient.getScoreList(studentID,Integer.valueOf(querySemaster),(currentPageNo - 1) * pageSize, pageSize);
        modelAndView.addObject("collection", collection);
        modelAndView.addObject("querySemaster", querySemaster);
        modelAndView.addObject("totalPageCount", totalPageCount);
        modelAndView.addObject("totalCount", totalCount);
        modelAndView.addObject("currentPageNo", currentPageNo);
        modelAndView.setViewName("/selectAllScore");
        return modelAndView;
    }
}
