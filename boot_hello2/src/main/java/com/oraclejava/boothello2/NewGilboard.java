package com.oraclejava.boothello2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("gilboard")
public class NewGilboard {
	// 초대가수(한국가수(김장훈), 미국가수(비틀스), 일본가수(미카))
	private KoreanMusician koreanMusician;

	// 공연
	public void execute() {
		koreanMusician.sing();
	}
	
	// Setter 메소드
	@Autowired		// 의존성 주입, by type
	@Qualifier("kimJangHun")	// by name
	private void setKoreanMusician(KoreanMusician koreanMusician) {
		this.koreanMusician = koreanMusician;
	}
	
	
	
}
