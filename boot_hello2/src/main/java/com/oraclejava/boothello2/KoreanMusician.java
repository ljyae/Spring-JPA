package com.oraclejava.boothello2;

import org.springframework.stereotype.Component;

// �Ʒ����� �Ⱦ��� no qualifying bean ������ �߻�!
@Component("kimJangHun")
public class KoreanMusician {
	
	// �뷡�� �θ��� �޼ҵ�
	public void sing() {
		System.out.println("����� ��������\n���� ���� ������...");
	}
}
