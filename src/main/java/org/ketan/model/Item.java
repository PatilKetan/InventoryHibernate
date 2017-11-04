package org.ketan.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ketan.helper.Address;

@Entity
public class Item {
	
	@Id
	@Column(name = "Item_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	
	@Column(name = "Item_Name")
	private String itemName;
	
	@Column(name = "Item_Supplier")
	private String supplierName;
	
	@Embedded
	private Address supplierAddress;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Manufactured_Date")
	private Date manufacturedDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Entry_Date")
	private Date entryDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Expiry_Date")
	private Date expiryDate;
	

	public Item() {}
	public Item(String itemName, String supplierName, Address supplierAddress, Date manufacturedDate,
			Date entryDate, Date expiryDate) {
		this.itemName = itemName;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.manufacturedDate = manufacturedDate;
		this.entryDate = entryDate;
		this.expiryDate = expiryDate;
	}
	
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", supplierName=" + supplierName
				+ ", supplierAddress=" + supplierAddress + ", manufacturedDate=" + manufacturedDate + ", entryDate="
				+ entryDate + ", expiryDate=" + expiryDate + "]";
	}
	
	
	//Dummy DUMB static object factories
	public static Item getJuiceItem() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return new Item("juice",
						"SM",
						new Address("Pune","411044"),
						sdf.parse("2014-09-11"),
						sdf.parse("2014-12-21"),
						sdf.parse("2015-09-11"));
	}
	public static Item getCornflakesItem() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return new Item("Corn Flakes",
						"RK",
						new Address("Chennai","523054"),
						sdf.parse("2014-09-11"), 
						sdf.parse("2014-12-21"), 
						sdf.parse("2015-09-11"));
	}
	public static Item getLaysItem() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return new Item("Lays",
						"VM", 
						new Address("Delhi","343902"),
						sdf.parse("2014-09-11"), 
						sdf.parse("2014-12-21"), 
						sdf.parse("2015-09-11"));
	}
	
}
