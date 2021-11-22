package com.oraclejava.boot_saving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("saving")
public class NewSaving {
	
	// ��������(savingBank) �ʵ�
	private SavingBank savingBank;
	
	
	// ���μ��� ����(execute) �޼ҵ�
	public void execute() {
		savingBank.sale();
	}

	
	// �������� set�޼ҵ�(setSavingBank) �޼���(DI)
	@Autowired
	@Qualifier("oracle")
	private void setSavingBank(SavingBank savingBank) {
		this.savingBank = savingBank;
	}
	
	
}
