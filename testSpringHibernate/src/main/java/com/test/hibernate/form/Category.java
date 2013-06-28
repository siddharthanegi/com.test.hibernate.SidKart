package com.test.hibernate.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="Category")
@Entity(name="Category")
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name="CategoryID")
	private Integer id;
	
	@Column(name="Category")
	private String category;
	
	public Category(){
		category="Others";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
