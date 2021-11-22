package com.oraclejava.bootjpa;

import org.springframework.data.repository.CrudRepository;

import com.oraclejava.bootjpa.entities.Customer;

/* repository(=저장소)
 * entity와 1:1로 대응
 * 상속자가 될 수 있다(java interface)
 																					entity			ID	*/				
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
