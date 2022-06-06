package com.example.clientStudent;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@MapperScan("com.example.clientStudent.mapper")
@ComponentScan(basePackages= {"com.example.clientStudent"})
@EnableJpaRepositories(basePackages= {"com.example.clientStudent.mapper"})
@EntityScan(basePackages= {"com.example.clientStudent.entity"})
public class ClientStudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientStudentApplication.class, args);
    }

}
