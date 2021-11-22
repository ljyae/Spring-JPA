package com.oraclejava.boothello2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("gilboard")
public class NewGilboard {
	// �ʴ밡��(�ѱ�����(������), �̱�����(��Ʋ��), �Ϻ�����(��ī))
	private KoreanMusician koreanMusician;

	// ����
	public void execute() {
		koreanMusician.sing();
	}
	
	// Setter �޼ҵ�
	@Autowired		// ������ ����, by type
	@Qualifier("kimJangHun")	// by name
	private void setKoreanMusician(KoreanMusician koreanMusician) {
		this.koreanMusician = koreanMusician;
	}
	
	
	
}
