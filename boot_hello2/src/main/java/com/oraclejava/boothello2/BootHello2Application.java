package com.oraclejava.boothello2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootHello2Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Spring boot 시작");
		
		//HelloWorld 인스턴스(객체)를 생성한 후 sayHi() 메소드를 호출하는 문장 작성
		/*
		 * HelloWorld helloWorld = new HelloWorld(); 	// 결합도가 강!
		 * helloWorld.sayHi();
		 */
		
		ConfigurableApplicationContext ctx = 
				SpringApplication.run(BootHello2Application.class, args);
		
		// 낮은 결합도
		// by type(기본값)
		// No bean named 'koreanMusician' available
		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		helloWorld.sayHi();
		
		/*
		 * KoreanMusician koreanMusician = new KoreanMusician(); 
		 * koreanMusician.sing();
		 */
		
		// by name(여러 개가 존재할 때)
		/*
		KoreanMusician koreanMusician = ctx.getBean("koreanMusician",KoreanMusician.class);
		koreanMusician.sing();
		*/
		
		NewGilboard newGilboard = ctx.getBean(NewGilboard.class);
		newGilboard.execute();
		
		// 메모리 누수를 방지하기 위해
		ctx.close();
	}

}
