package com.oraclejava.bootjpa.services;

import java.util.List;

import com.oraclejava.bootjpa.entities.Customer;

public interface CustomerService {
	
	// ��� �� ��� ���ϱ�
	List<Customer> findAll();
			
	// �� ���� �� ���ϱ�
	Customer findById(Integer id);
	
	// �� ����(�߰�/����)
	Customer save(Customer customer);
	
	// �� ����
	void delete(Customer customer);

}
