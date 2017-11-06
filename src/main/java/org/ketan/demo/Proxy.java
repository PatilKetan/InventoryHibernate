package org.ketan.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Proxy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Proxy_Id")
	private int id;
	@ElementCollection // As we are using collection 
	//@ElementCollection(fetch = FetchType.EAGER) for Eager Initialization
	@JoinTable(name = "Proxy_List") //Name For the table name used to store the address
	@GenericGenerator(name="inc-gen",strategy="increment")
	@CollectionId(columns = {@Column(name="Proxy_List_Id")}, generator = "inc-gen", type = @Type(type = "long"))
	private List<String> proxyList = new ArrayList<String>();
	
	
	public Proxy() {
	}
	public Proxy(int id, List<String> proxyList) {
		this.id = id;
		this.proxyList = proxyList;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getProxyList() {
		return proxyList;
	}
	public void setProxyList(List<String> proxyList) {
		this.proxyList = proxyList;
	}
	
	@Override
	public String toString() {
		return "Proxy [id=" + id + ", proxyList=" + proxyList + "]";
	}
	
}
