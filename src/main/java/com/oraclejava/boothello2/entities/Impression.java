package com.oraclejava.boothello2.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="impression")
public class Impression implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * id int primary key,
	 * impression varchar2(2000), 
	 * sul_id int not null
	 */
	
	@Id	
	@GeneratedValue(generator = "seq_impression", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_impression", sequenceName = "seq_impression", allocationSize = 1)
	private Integer id;
		
	private String impression;	
	
	public Impression() {
		super();		
	}

	public Impression(String impression, Sul sul) {
		super();
		this.impression = impression;
		this.sul = sul;
	}

	// 술 하나에 대한 감상문이 여러 개
	@ManyToOne
	@JoinColumn(name = "sul_id")
	private Sul sul;		// 조회를 위함

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public Sul getSul() {
		return sul;
	}

	public void setSul(Sul sul) {
		this.sul = sul;
	}
	
	
	
}
