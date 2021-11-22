package com.oraclejava.boothello2.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="sul")
public class Sul implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "seq_sul", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_sul", sequenceName = "SEQ_SUL", allocationSize = 1)
	@Column(name="id")
	private Integer id;
	
	@Column(name="brand")
	private String brand;
	
	@ManyToOne	(fetch = FetchType.LAZY)			// 다 대 일, 소유자 테이블
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "type_id", nullable = true) 				// typeId도 가능
	private SulType sulType;
	
	@OneToMany(mappedBy = "sul", cascade = CascadeType.ALL)
	private Set<Impression> impressions; 	// = new HashSet<Impression>();
	// 위처럼 써도 되나, 없으면 jpa가 자동으로 만들어 줌
	
	
	public Set<Impression> getImpressions() {
		return impressions;
	}

	public void setImpressions(Set<Impression> impressions) {
		this.impressions = impressions;
	}

	public SulType getSulType() {
		return sulType;
	}

	public void setSulType(SulType sulType) {
		this.sulType = sulType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Sul [id=" + id + ", brand=" + brand + ", sulType=" + sulType + "]";
	}
	
	
}
