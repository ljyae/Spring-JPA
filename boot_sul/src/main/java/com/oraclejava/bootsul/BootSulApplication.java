package com.oraclejava.bootsul;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.oraclejava.bootsul.entities.Sul;
import com.oraclejava.bootsul.services.SulService;

@SpringBootApplication
public class BootSulApplication implements CommandLineRunner {
	
	private static Logger logger = LoggerFactory.getLogger(BootSulApplication.class);

	@Autowired
	//private SulRepository sulRepository; 		// �ʵ�
	private SulService sulService;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BootSulApplication.class, args);
		
		ctx.close();
	}

	@Transactional(readOnly = false)
	@Override
	public void run(String... args) throws Exception {
		logger.info("---list sul");
		
		/*Iterable<Sul> suls = sulRepository.findAll();
		
		suls.forEach(sul -> {
			logger.info(sul.toString());
		});*/
		
		// �� �߰�
		//addSul();
		
		// �� ����
		//updateSul();
		
		// �� ����
		deleteSul();
		
		List<Sul> suls = sulService.findAll();
		listSul(suls);
	}
	
	private static void listSul(List<Sul> suls) {
		suls.forEach(sul -> {
			logger.info(sul.toString());
		});
	}
	
	private void addSul() {
		Sul sul = new Sul();
		sul.setId(5);
		sul.setBrand("ī��");
		sul.setType("����");
		sulService.save(sul);
	}
	
	public void updateSul() {
		Sul sul = sulService.findById(5);
		sul.setBrand("Cass");
		sulService.save(sul);
	}
	
	public void deleteSul() {
		Sul sul = sulService.findById(5);
		sulService.delete(sul);
	}

}
