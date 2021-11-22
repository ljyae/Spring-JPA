package com.oraclejava.boothello2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.oraclejava.boothello2.entities.Sul;
import com.oraclejava.boothello2.entities.SulType;
import com.oraclejava.boothello2.repos.SulRepository;
import com.oraclejava.boothello2.repos.SulTypeRepository;

@Service
@Transactional
public class SulServiceImpl implements SulService{

	@Autowired
	private SulRepository sulRepository;
	
	@Autowired
	private SulTypeRepository sulTypeRepository;	
	
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
	public Pair<List<Sul>, Integer> findAll(int page, int pageSize, String order) {									// 일 대 다					가나다 순		Sort.by("sulType.type").and(Sort.by("brand").descending())
		Page<Sul> suls = sulRepository.findAll(PageRequest.of(page-1, pageSize, Sort.by(order)));	// page가 0부터 시작이라 헷갈리니 -1해서 1부터로~
		int totalPage = suls.getTotalPages();
		List<Sul> sulList = new ArrayList<>();
		suls.forEach(sul -> {
			sulList.add(sul);
		});
		
		Pair<List<Sul>, Integer> pagingPair = Pair.of(sulList, totalPage);
		
		return pagingPair;
	}
	
	// 위의 메소드와 이하동문, 구아바 사용
	@Transactional(readOnly = true)
	@Override
	public List<SulType> findAllType() {
		Iterable<SulType> sulTypes = sulTypeRepository.findAll();		
		return Lists.newArrayList(sulTypes);
	}

	
}
