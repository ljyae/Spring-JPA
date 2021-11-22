package com.oraclejava.boothello2;

import org.springframework.stereotype.Component;

// 아래줄은 안쓰면 no qualifying bean 에러가 발생!
@Component("kimJangHun")
public class KoreanMusician {
	
	// 노래를 부르는 메소드
	public void sing() {
		System.out.println("사노라면 언젠가는\n밝은 날도 오겠지...");
	}
}
