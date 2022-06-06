package com.example.clientStudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:yln
 * @create:2022-05-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scourse {
    private int s_no;
    private String c_no;
    private int c_score;
}
