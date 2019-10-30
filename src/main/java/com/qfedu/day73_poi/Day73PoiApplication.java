package com.qfedu.day73_poi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qfedu.day73_poi.dao")
public class Day73PoiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day73PoiApplication.class, args);
	}

}
