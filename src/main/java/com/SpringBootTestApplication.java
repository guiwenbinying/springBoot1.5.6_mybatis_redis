package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.gui.mapper")//将项目中对应的mapper类的路径加进来就可以了
//@ComponentScan(basePackages= "com.gui")//烧苗一些工具包
public class SpringBootTestApplication {

	public static void main(String[] args) {
		//springboot的入口文件
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
}
