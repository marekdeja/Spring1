package com.capgemini.springTask1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.capgemini.springTask1.hours.HoursService;


@SpringBootApplication
@EnableWebMvc
public class SpringTask1Application /*implements ApplicationRunner*/ {

//	@Autowired
//	private HoursService hoursService;
//	
	public static void main(String[] args) {
		SpringApplication.run(SpringTask1Application.class, args);
	}
	
//	@Override
//    public void run(ApplicationArguments applicationArguments) throws Exception {
//		System.out.println("HALO");
////		System.out.println((hoursService.getHours().get(0)).getDay());
//    }
}
