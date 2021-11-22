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
		
		Date date = new Date();									// ���� ����
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);

		// mav.addObject("msg", "���� �ð��� " + (new java.util.Date()) + "�Դϴ�.");
		mav.addObject("msg", "���� �ð��� " + formattedDate + "�Դϴ�.");
		return mav;
	}
	*/
	
	// �����
	@RequestMapping(value="/now2", method=RequestMethod.GET)
	public ModelAndView index() {
		LocalDate date = LocalDate.now();
		LocalTime now = LocalTime.now();			// ���� �ð��� ��� �ִ� ��ü
		ModelAndView mav = new ModelAndView();
		mav.setViewName("now2");		
		mav.addObject("time", now);
		mav.addObject("date", date);
		return mav;		
	}

}
