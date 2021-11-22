package com.oraclejava.boothello2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootHello2Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Spring boot ����");
		
		//HelloWorld �ν��Ͻ�(��ü)�� ������ �� sayHi() �޼ҵ带 ȣ���ϴ� ���� �ۼ�
		/*
		 * HelloWorld helloWorld = new HelloWorld(); 	// ���յ��� ��!
		 * helloWorld.sayHi();
		 */
		
		ConfigurableApplicationContext ctx = 
				SpringApplication.run(BootHello2Application.class, args);
		
		// ���� ���յ�
		// by type(�⺻��)
		// No bean named 'koreanMusician' available
		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		helloWorld.sayHi();
		
		/*
		 * KoreanMusician koreanMusician = new KoreanMusician(); 
		 * koreanMusician.sing();
		 */
		
		// by name(���� ���� ������ ��)
		/*
		KoreanMusician koreanMusician = ctx.getBean("koreanMusician",KoreanMusician.class);
		koreanMusician.sing();
		*/
		
		NewGilboard newGilboard = ctx.getBean(NewGilboard.class);
		newGilboard.execute();
		
		// �޸� ������ �����ϱ� ����
		ctx.close();
	}

}
