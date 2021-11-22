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
	
	// ȿ���� ���� �α׸� ���
	private static Logger logger = LoggerFactory.getLogger(BootJpaApplication.class);
	
	@Autowired
	// �����δ� setter �޼��� ���� ���̸� �� ������, �����ڵ� IQ ���
	// private CustomerRepository customerRepository
	private CustomerService customerService;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BootJpaApplication.class, args);
		
		//System.out.println("Hello boot jpa~");
		
		ctx.close();

	}

	@Transactional(readOnly = false)
	// ���� �޼ҵ忡���� Ʈ����� �ڵ�� �ȸԴ´�.(insert, update, delete)
	@Override
	public void run(String... args) throws Exception {
		logger.info("--- list customer");
		
		// ����ȣ �߰�
		//addCustomer();
		
		// ������ ����
		//updateCustomer();
		
		// ������ ����
		deleteCustomer();
		
		List<Customer> customers = customerService.findAll();		// select * from customer;
		
		listCustomer(customers);
		/*
		 * // findAll()�� �ƹ��͵� ���ָ� ��� entity�� ������ 
		 * customers.forEach(customer -> {
		 * logger.info(customer.toString()); });
		 */
	}
	
	private static void listCustomer(List<Customer> customers) {
		// findAll()�� �ƹ��͵� ���ָ� ��� entity�� ������
				customers.forEach(customer -> {
					logger.info(customer.toString());
				});
	}
	
	//@Transactional
	// ������ jpa�� �����͸� �߰�/����/������ ���� �ݵ�� ĸ��ȭ�� Ŭ������ ���� Ʈ�������� �õ��ؾ� ������, or ���� ��ü�� ���൵ �ȵ�
	private void addCustomer() {
		// ���� �߰�
		// ����ȣ�� ������ ���Դ�
		Customer cust = new Customer();
		cust.setFirstName("����");
		cust.setLastName("��");
		cust.setId(5);				//	���� ���̵��� �� ���� ������ ������
		// 1973.6.29
		LocalDate birthdate = LocalDate.of(1991, 1, 9);
		cust.setBirthDate(java.sql.Date.valueOf(birthdate));		// '1990-09-16','yyyy-mm-dd'
		customerService.save(cust);		
	}
	
	// ������ ����
	public void updateCustomer() {
		// ������(5) �����͸� �����Ѵ�.
		// �������� ��������� 2021-11-15�� �����Ѵ�.
		Customer cust = customerService.findById(5);
		LocalDate birthdate = LocalDate.of(2021, 11, 15);
		cust.setBirthDate(java.sql.Date.valueOf(birthdate));
		customerService.save(cust);
	}
	
	// ������ ����
	public void deleteCustomer() {
		// ������ ���� �����Ѵ�
		// -> �԰� Ʀ(����)
		Customer cust = customerService.findById(5);
		customerService.delete(cust);
		
	}

}
