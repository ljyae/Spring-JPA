package com.oraclejava.boothello2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oraclejava.boothello2.entities.SulType;
import com.oraclejava.boothello2.repos.SulTypeRepository;

@Service
@Transactional
public class SulTypeServiceImpl implements SulTypeService {

	@Autowired
	private SulTypeRepository sulTypeRepository;

	@Transactional(readOnly = true)
	@Override
	public List<SulType> findAll() {
		Iterable<SulType> sulTypes = sulTypeRepository.findAll();		// SulType entity의 id를 다 찾아서 entity를 for-each loop를 위한 타겟으로 만들어 줌
		List<SulType> sulTypeList = new ArrayList<SulType>();			// SulType entity를 ArrayList로 만들고
		sulTypes.forEach(sulTypeList::add);										// 그 리스트를 sulTypes forEach에 추가
		return sulTypeList;															// 리스트를 돌려줌
		// return Lists.newArrayList(sulTypes);
	}

	@Transactional(readOnly = true)
	@Override
	public SulType findById(Integer id) {		
		return sulTypeRepository.findById(id).get();
	}


	@Override
	public SulType save(SulType sulType) {		
		return sulTypeRepository.save(sulType);
	}


	@Override
	public void delete(SulType sulType) {
		sulTypeRepository.delete(sulType);		
	}

}
