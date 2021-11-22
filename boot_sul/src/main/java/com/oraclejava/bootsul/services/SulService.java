package com.oraclejava.bootsul.services;

import java.util.List;

import com.oraclejava.bootsul.entities.Sul;

public interface SulService {
	
	List<Sul> findAll();
	
	Sul findById(Integer id);
	
	Sul save(Sul sul);
	
	void delete(Sul sul);

}
