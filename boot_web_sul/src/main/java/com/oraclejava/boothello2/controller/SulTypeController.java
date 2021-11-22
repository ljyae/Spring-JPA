package com.oraclejava.boothello2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oraclejava.boothello2.entities.SulType;
import com.oraclejava.boothello2.services.SulTypeService;

@Controller
@RequestMapping(value="/sultypes")		// url 받아서
public class SulTypeController {
	
	@Autowired
	private SulTypeService sulTypeService;
	
	@RequestMapping(method = RequestMethod.GET)		// 안으로 들어감
	public ModelAndView getSulTypes() {						
		ModelAndView mav = new ModelAndView("sultypes");		// 생성자에 주는 것도 아래와 같음
		List<SulType> sulTypeList = sulTypeService.findAll();
		//mav.setViewName("sultypes");
		mav.addObject("sulTypes", sulTypeList);			// sulTypeList를 sulTypes 이름으로 view(html)에 넘김
		return mav;
	}
	
	// 새로운 주종 추가		url -> /sultypes/new
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String newSulType(Model model) {
		model.addAttribute("sulType", new SulType());		// 새로운 sulType을 만들고
		return "sulTypeAdd"; 		// sulTypeAdd 화면으로 감
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveSulType(SulType sulType) {
		sulTypeService.save(sulType);
		return "redirect:/sultypes";		
	}
	
	// 주종 수정
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
							  // == @PathVariable int id,
	public String editSulType(@PathVariable("id") Integer id, Model model) {
		SulType sulType = sulTypeService.findById(id);
		model.addAttribute("sulType", sulType);		
		return "sulTypeEdit";		
	}
	
	// 주종 삭제
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteSulType(@PathVariable int id) {
		SulType sulType = sulTypeService.findById(id);
		sulTypeService.delete(sulType);
		return "redirect:/sultypes";
	}
}
