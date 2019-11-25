package org.huang;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.huang.repository")
public class MenuApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(MenuApplication.class,args);
    }
}
