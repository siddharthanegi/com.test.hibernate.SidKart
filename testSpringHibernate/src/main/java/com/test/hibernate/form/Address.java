package com.test.hibernate.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="Address")
@Entity (name="Address")
public class Address {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	

	@Column(name="city_name")
	private String cityName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cityName;
	}

	public void setCname(String cityName) {
		this.cityName = cityName;
	}

	
	

}
