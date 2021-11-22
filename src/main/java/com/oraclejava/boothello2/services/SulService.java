package com.oraclejava.boothello2.services;

import java.util.List;

import org.springframework.data.util.Pair;

import com.oraclejava.boothello2.entities.Sul;
import com.oraclejava.boothello2.entities.SulType;

public interface SulService {
	
	Pair<List<Sul>, Integer> findAll(int page, int pageSize, String order);
	
	List<SulType> findAllType();
	
	Sul findById(Integer id);
	
	Sul save(Sul sul);
	
	void delete(Sul sul);

}
