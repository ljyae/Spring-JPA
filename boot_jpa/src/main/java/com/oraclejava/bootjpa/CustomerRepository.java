package com.oraclejava.bootjpa;

import org.springframework.data.repository.CrudRepository;

import com.oraclejava.bootjpa.entities.Customer;

/* repository(=�����)
 * entity�� 1:1�� ����
 * ����ڰ� �� �� �ִ�(java interface)
 																					entity			ID	*/				
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
