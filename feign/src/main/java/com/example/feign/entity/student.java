package com.example.feign.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student {
    private int s_id;
    private String s_name;
    private String s_number;
    private String s_gender;
    private String s_school;
    private String s_pro;
    private String s_telephone;
    private String s_address;
    private String c_no;
    private int c_score;
}
