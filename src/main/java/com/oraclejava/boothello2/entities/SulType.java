package com.oraclejava.boothello2.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sul_type")
public class SulType implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(generator = "seq_sultype", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_sultype", sequenceName = "seq_sultype", allocationSize = 1)		// 1씩 증가됨
	@Column(name="id")
	private Integer id;
	
	@Column(name="type")
	private String type;
	
	// Sul entity의 private SulType sulType과 연결
	@OneToMany(mappedBy ="sulType", cascade = CascadeType.REMOVE)
	private Set<Sul> suls;

	public Set<Sul> getSuls() {
		return suls;
	}

	public void setSuls(Set<Sul> suls) {
		this.suls = suls;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SulType [id=" + id + ", type=" + type + "]";
	}
	
	
	
}
