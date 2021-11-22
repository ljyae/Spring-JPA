package com.oraclejava.boothello2;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootHello2Application {
	
	private static Logger logger = LoggerFactory.getLogger(BootHello2Application.class);

	public static void main(String[] args) throws IOException {
		//ConfigurableApplicationContext ctx = 
				SpringApplication.run(BootHello2Application.class, args);
		
		//logger.info("spring boot running...");
		
		//System.in.read();
		
		//ctx.close();
	}

}
