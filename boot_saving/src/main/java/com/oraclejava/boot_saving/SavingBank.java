package com.oraclejava.boot_saving;

import org.springframework.stereotype.Component;

// �������� Ŭ����

@Component("oracle")	// ����Ŭ ���������� �ǹ��մϴ�.
public class SavingBank {
	
	// ������ǰ�� �Ǹ��ϴ� �޼ҵ�
	public void sale() {
		System.out.println("����Ŭ ���KBO ���� 2030: �������� ����� �ѱ��ø��� Ƽ���� 2�徿 ����� �帳�ϴ�!");
	}
}
