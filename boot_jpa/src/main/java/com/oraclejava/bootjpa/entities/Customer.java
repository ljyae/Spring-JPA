package com.oraclejava.bootjpa.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private Integer id;		// Number(38,0) Long�� ����	
	
	@Column(name="firstName")
	private String firstName; // Varchar , Varchar2 -> String	
	
	@Column(name="lastName")
	private String lastName;	
	
	@Column(name="birthDate")
	private Date birthDate;

	// ���콺 ��Ŭ�� -> Source ...  -> Generate -> ToString
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ "]";
	}
	
	// getter, setter �޼ҵ� ����
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
}
