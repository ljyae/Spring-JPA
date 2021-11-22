package com.oraclejava.boot_saving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootSavingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("BootSavindApplication Ω√¿€");
		
		ConfigurableApplicationContext ctx = SpringApplication.run(BootSavingApplication.class, args);
		
		NewSaving newSaving = ctx.getBean(NewSaving.class);
		newSaving.execute();
		
		ctx.close();
	}

}
