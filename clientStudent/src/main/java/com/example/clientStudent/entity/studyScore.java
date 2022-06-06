package com.example.clientStudent.entity;

public class studyScore {
    String c_no;//课程号
    String c_name;//课程名
    int c_credit;//学分
    int c_studyhour;//学时
    int c_score;//成绩
    String t_name;//授课老师
    int c_semaster;//学期
//    int s_no;//学号

    @Override
    public String toString() {
        return "studyScore{" +
                "c_no='" + c_no + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_credit=" + c_credit +
                ", c_studyhour=" + c_studyhour +
                ", c_score=" + c_score +
                ", t_name='" + t_name + '\'' +
                ", c_semaster=" + c_semaster +
//                ", s_no=" + s_no +
                '}';
    }

    public String getC_no() {
        return c_no;
    }

    public void setC_no(String c_no) {
        this.c_no = c_no;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getC_credit() {
        return c_credit;
    }

    public void setC_credit(int c_credit) {
        this.c_credit = c_credit;
    }

    public int getC_studyhour() {
        return c_studyhour;
    }

    public void setC_studyhour(int c_studyhour) {
        this.c_studyhour = c_studyhour;
    }

    public int getC_score() {
        return c_score;
    }

    public void setC_score(int c_score) {
        this.c_score = c_score;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public int getC_semaster() {
        return c_semaster;
    }

    public void setC_semaster(int c_semaster) {
        this.c_semaster = c_semaster;
    }
//
//    public int getS_no() {
//        return s_no;
//    }
//
//    public void setS_no(int s_no) {
//        this.s_no = s_no;
//    }
}