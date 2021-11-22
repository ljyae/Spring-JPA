package com.oraclejava.boot_saving;

import org.springframework.stereotype.Component;

// 저축은행 클래스

@Component("oracle")	// 오라클 저축은행을 의미합니다.
public class SavingBank {
	
	// 금융상품을 판매하는 메소드
	public void sale() {
		System.out.println("오라클 룰루KBO 적금 2030: 위적금은 만기시 한국시리즈 티켓을 2장씩 무료로 드립니다!");
	}
}
