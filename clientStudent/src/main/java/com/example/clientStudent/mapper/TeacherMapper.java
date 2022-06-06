package com.example.clientStudent.mapper;

import com.example.clientStudent.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper {
    Teacher selectByN(int t_no,String t_name);
    int register(Teacher teacher);
}
