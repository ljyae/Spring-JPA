package com.oraclejava.bootsul.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.oraclejava.bootsul.SulRepository;
import com.oraclejava.bootsul.entities.Sul;

@Service
@Transactional
public class SulServiceImpl implements SulService{

	@Autowired
	private SulRepository sulRepository;
	
	
	@Override
	public Sul save(Sul sul) {
		return sulRepository.save(sul);
	}

	@Override
	public void delete(Sul sul) {
		sulRepository.delete(sul);	
	}

	@Transactional(readOnly = true)
	@Override
	public Sul findById(Integer id) {
		return sulRepository.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Sul> findAll() {
		Iterable<Sul> suls = sulRepository.findAll();
		List<Sul> sulList = new ArrayList<>();
		suls.forEach(sul -> {
			sulList.add(sul);
		});
		return sulList;
	}
	
	

}
