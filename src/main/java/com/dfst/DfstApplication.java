package com.dfst;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dfst.dao")
public class DfstApplication {

	public static void main(String[] args) {
		SpringApplication.run(DfstApplication.class, args);
	}
}
