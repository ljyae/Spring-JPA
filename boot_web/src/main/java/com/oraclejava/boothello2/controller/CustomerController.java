package com.oraclejava.boothello2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller		// 여기는 컨트롤러가 되기 위해선 반드시 붙여준다.
public class CustomerController {
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();		// 모델앤드뷰 객체 생성
		mav.setViewName("customers");			// 뷰 이름
		mav.addObject("msg", "안녕하세요, ?입니다. 잘 부탁드려요.");			// 모델
		mav.addObject("msg2", "또, 안녕");
		return mav;									// 모델앤드뷰 객체 리턴
	}
}
