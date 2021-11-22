package com.oraclejava.bootjpa;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.oraclejava.bootjpa.entities.Customer;
import com.oraclejava.bootjpa.services.CustomerService;

@SpringBootApplication
public class BootJpaApplication implements CommandLineRunner {
	
	// 효율을 위해 로그를 사용
	private static Logger logger = LoggerFactory.getLogger(BootJpaApplication.class);
	
	@Autowired
	// 실제로는 setter 메서드 위에 붙이면 더 좋지만, 개발자들 IQ 고려
	// private CustomerRepository customerRepository
	private CustomerService customerService;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BootJpaApplication.class, args);
		
		//System.out.println("Hello boot jpa~");
		
		ctx.close();

	}

	@Transactional(readOnly = false)
	// 이하 메소드에서는 트랜잭션 코드는 안먹는다.(insert, update, delete)
	@Override
	public void run(String... args) throws Exception {
		logger.info("--- list customer");
		
		// 박찬호 추가
		//addCustomer();
		
		// 강감찬 수정
		//updateCustomer();
		
		// 강감찬 삭제
		deleteCustomer();
		
		List<Customer> customers = customerService.findAll();		// select * from customer;
		
		listCustomer(customers);
		/*
		 * // findAll()에 아무것도 안주면 모든 entity를 가져옴 
		 * customers.forEach(customer -> {
		 * logger.info(customer.toString()); });
		 */
	}
	
	private static void listCustomer(List<Customer> customers) {
		// findAll()에 아무것도 안주면 모든 entity를 가져옴
				customers.forEach(customer -> {
					logger.info(customer.toString());
				});
	}
	
	//@Transactional
	// 스프링 jpa는 데이터를 추가/수정/삭제할 때는 반드시 캡슐화한 클래스를 통해 트랜젝션을 시도해야 성공함, or 쿼리 자체가 실행도 안됨
	private void addCustomer() {
		// 고객님 추가
		// 박찬호가 고객으로 들어왔다
		Customer cust = new Customer();
		cust.setFirstName("감찬");
		cust.setLastName("강");
		cust.setId(5);				//	같은 아이디일 때 이전 내용이 수정됨
		// 1973.6.29
		LocalDate birthdate = LocalDate.of(1991, 1, 9);
		cust.setBirthDate(java.sql.Date.valueOf(birthdate));		// '1990-09-16','yyyy-mm-dd'
		customerService.save(cust);		
	}
	
	// 데이터 수정
	public void updateCustomer() {
		// 강감찬(5) 데이터를 수정한다.
		// 강감찬의 생년월일을 2021-11-15로 수정한다.
		Customer cust = customerService.findById(5);
		LocalDate birthdate = LocalDate.of(2021, 11, 15);
		cust.setBirthDate(java.sql.Date.valueOf(birthdate));
		customerService.save(cust);
	}
	
	// 데이터 삭제
	public void deleteCustomer() {
		// 강감찬 고객을 삭제한다
		// -> 먹고 튐(삭제)
		Customer cust = customerService.findById(5);
		customerService.delete(cust);
		
	}

}
