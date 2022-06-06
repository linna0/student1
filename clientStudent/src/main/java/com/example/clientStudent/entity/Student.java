package com.example.clientStudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int s_id;
    private String s_name;
    private String s_number;
    private String s_gender;
    private String s_school;
    private String s_pro;
    private String s_telephone;
    private String s_address;
}
