package com.xk.ziyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**

* @Description:

* @Author: wanghaixue

* @CreateDate: 2019/2/18 21:39

* @Version: 1.0

*/
@CrossOrigin
/*@ServletComponentScan    打开过滤器的时候把这里注释去掉*/
@SpringBootApplication
@MapperScan("com.xk.ziyu.dao")
public class ZiyuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZiyuApplication.class, args);
	}

}


