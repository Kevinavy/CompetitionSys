package com.kevinavy.competitionsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.kevinavy.competitionsys.mapper", "com.kevinavy.competitionsys.security.mapper"})
@SpringBootApplication
public class CompetitionSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompetitionSysApplication.class, args);
    }

}
