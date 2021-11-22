package com.oraclejava.boothello2.controller;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NowController {
	/*
	@RequestMapping(value="/now", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("now");		
		
		Date date = new Date();									// 포맷 지정
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);

		// mav.addObject("msg", "현재 시간은 " + (new java.util.Date()) + "입니다.");
		mav.addObject("msg", "현재 시간은 " + formattedDate + "입니다.");
		return mav;
	}
	*/
	
	// 강사님
	@RequestMapping(value="/now2", method=RequestMethod.GET)
	public ModelAndView index() {
		LocalDate date = LocalDate.now();
		LocalTime now = LocalTime.now();			// 현재 시간을 담고 있는 객체
		ModelAndView mav = new ModelAndView();
		mav.setViewName("now2");		
		mav.addObject("time", now);
		mav.addObject("date", date);
		return mav;		
	}

}
