package com.oraclejava.boothello2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller		// ����� ��Ʈ�ѷ��� �Ǳ� ���ؼ� �ݵ�� �ٿ��ش�.
public class CustomerController {
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();		// �𵨾ص�� ��ü ����
		mav.setViewName("customers");			// �� �̸�
		mav.addObject("msg", "�ȳ��ϼ���, ?�Դϴ�. �� ��Ź�����.");			// ��
		mav.addObject("msg2", "��, �ȳ�");
		return mav;									// �𵨾ص�� ��ü ����
	}
}
