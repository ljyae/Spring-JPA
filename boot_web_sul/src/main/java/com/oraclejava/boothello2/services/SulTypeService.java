package com.oraclejava.boothello2.services;

import java.util.List;

import com.oraclejava.boothello2.entities.SulType;

public interface SulTypeService {
	
	List<SulType> findAll();
	
	SulType findById(Integer id);
	
	SulType save(SulType sulType);
	
	void delete(SulType sulType);
	
}
