/*This is demo for One to Many mapping
 * we assume here that one supplier can have / provide
 * many items
 */
package org.ketan.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.ketan.helper.Address;

@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Supplier_Id")
	private int id;
	@Column(name = "Supplier_Name")
	private String name;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride (name = "city", column = @Column(name = "Supplier_City")),
		@AttributeOverride (name = "pincode", column = @Column(name = "Supplier_Pincode"))
	})
	private Address address;
	@OneToMany
	private List<Item> itemList = new ArrayList<Item>();
	
	
	public Supplier() {
	}
	public Supplier(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> item) {
		this.itemList = item;
	}
	
	
	//Dummy DUMB static object factories
	public static Supplier getJackSupplier() {
		return new Supplier(1, "JD", new Address("Pune","411044"));
	}
	public static Supplier getJimSupplier() {
		return new Supplier(2, "JB", new Address("Chennai","531052"));
	}
	public static Supplier getJonnySupplier() {
		return new Supplier(3, "JW", new Address("Delhi","310134"));
	}
}
