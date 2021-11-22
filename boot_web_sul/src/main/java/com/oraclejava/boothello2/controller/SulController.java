package com.oraclejava.boothello2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oraclejava.boothello2.entities.Impression;
import com.oraclejava.boothello2.entities.Sul;
import com.oraclejava.boothello2.services.SulService;

@Controller
public class SulController {
	
	@Autowired
	private SulService sulService;
	
	private static int PAGE_SIZE = 10;
	
	@RequestMapping(value="/suls", method=RequestMethod.GET)
	public ModelAndView index(@RequestParam(required = false) Integer page) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("suls");
		Pair<List<Sul>, Integer> pagingPair = sulService.findAll(page == null ? 1 : page, PAGE_SIZE, "brand");
		List<Sul> sulList = pagingPair.getFirst();
		int begin = 1;	
		int end = pagingPair.getSecond();
		mav.addObject("sulList", sulList);
		mav.addObject("beginIndex", begin);
		mav.addObject("endIndex", end);
		return mav;
	}
	
	// 술 추가
	@RequestMapping(value="/suls/new", method=RequestMethod.GET)
	public String showNewForm(Model model) {
		model.addAttribute("sul", new Sul());			// (키, 값)
		model.addAttribute("pageTitle", "새로운 술 추가");
		model.addAttribute("sulTypeList", sulService.findAllType());
		return "sul_form";		// 뷰 이름
	}
	
	// 술 저장
	// 저장 후 목록으로 감
	@RequestMapping(value="/suls/save", method=RequestMethod.POST)
	public String saveSul(Sul sul) {
		sulService.save(sul);
		return "redirect:/suls";		
	}
	
	//  술 수정						sul_form.html에서 <input type="hidden" th:field="*{id}">, id를 찾음
	@RequestMapping(value="/suls/edit/{id}", method=RequestMethod.GET)	
	 public String showEditForm(@PathVariable("id") Integer id, Model model) { 
	  	Sul sul = sulService.findById(id);
	  	model.addAttribute("sul", sul);
	  	model.addAttribute("pageTitle", "기존 술 수정");
	  	model.addAttribute("sulTypeList", sulService.findAllType());
		return "sul_form";	 
	  }
	
	//  상세					
	@RequestMapping(value="/suls/detail/{id}", method=RequestMethod.GET)	
	 public String showDetail(@PathVariable("id") Integer id, Model model) { 
	  	Sul sul = sulService.findById(id);
	  	model.addAttribute("sul", sul);	  	
		return "sul_detail";	 
	  }
	 
	//  술 삭제
	@RequestMapping(value="/suls/delete/{id}", method=RequestMethod.GET)	
	 public String deleteSul(@PathVariable("id") Integer id, Model model) { 
	  	Sul sul = sulService.findById(id);
	  	sulService.delete(sul);
		return "redirect:/suls";	 
	  }
	
	// 감상평 작성
	@RequestMapping(value="/suls/review_ok", method=RequestMethod.POST)	
	public String reviewOK(@RequestParam Integer sulId, @RequestParam String impression) {
		Sul sul = sulService.findById(sulId);
		sul.getImpressions().add(new Impression(impression, sul));
		sulService.save(sul);		// 감상평을 추가
		return "redirect:/suls";		
	}
	
}
