package com.oraclejava.boot_saving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("saving")
public class NewSaving {
	
	// 저축은행(savingBank) 필드
	private SavingBank savingBank;
	
	
	// 프로세스 실행(execute) 메소드
	public void execute() {
		savingBank.sale();
	}

	
	// 저축은행 set메소드(setSavingBank) 메서드(DI)
	@Autowired
	@Qualifier("oracle")
	private void setSavingBank(SavingBank savingBank) {
		this.savingBank = savingBank;
	}
	
	
}
