package org.ketan.helper;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column (name = "City")
	private String city;
	@Column (name = "Pincode")
	private String pincode;
	
	public Address() {
	}
	public Address(String city, String pincode) {
		this.city = city;
		this.pincode = pincode;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Adderss [city=" + city + ", Pincode=" + pincode + "]";
	}
	
	
}
