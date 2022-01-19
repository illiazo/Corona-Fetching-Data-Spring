package com.coronaUpdates.demo;

import com.coronaUpdates.demo.models.homeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.ui.Model;


@SpringBootApplication
@EnableScheduling
public class CoronaUpdatesApplication {

	public static void main(String[] args) {
		System.out.println("test");
		SpringApplication.run(CoronaUpdatesApplication.class, args);
	}


}
