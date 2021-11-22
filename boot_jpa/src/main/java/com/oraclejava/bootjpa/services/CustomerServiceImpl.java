package com.oraclejava.bootjpa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oraclejava.bootjpa.CustomerRepository;
import com.oraclejava.bootjpa.entities.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Transactional(readOnly = true)		// 수정 불가
	@Override
	public List<Customer> findAll() {
		Iterable<Customer> customers = customerRepository.findAll();
		List<Customer> custList = new ArrayList<>();
		customers.forEach(cust -> {
			custList.add(cust);
		});
		return custList;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Customer findById(Integer id) {
		
		return customerRepository.findById(id).get();
	}

	@Override
	public Customer save(Customer customer) {		
		return customerRepository.save(customer);
	}

	@Override
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}

}
