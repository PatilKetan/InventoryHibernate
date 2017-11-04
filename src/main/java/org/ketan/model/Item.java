package org.ketan.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
	
	@Column(name = "Item_Supplier_Id")
	private int supplierId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Manufactured_Date")
	private Date manufacturedDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Entry_Date")
	private Date entryDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Expiry_Date")
	private Date expiryDate;
	
	
	public Item() {
	}
	public Item(String itemName, int supplierId, Date manufacturedDate, Date entryDate,
			Date expiryDate) {
		this.itemName = itemName;
		this.supplierId = supplierId;
		this.manufacturedDate = manufacturedDate;
		this.entryDate = entryDate;
		this.expiryDate = expiryDate;
	}
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public Date getManufacturedDate() {
		return manufacturedDate;
	}
	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", supplierId=" + supplierId
				+ ", manufacturedDate=" + manufacturedDate + ", entryDate=" + entryDate + ", expiryDate=" + expiryDate
				+ "]";
	}
	
	//Dummy DUMB static object factories
	public static Item getJuiceItem() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return new Item("juice",
						1,
						sdf.parse("2014-09-11"),
						sdf.parse("2014-12-21"),
						sdf.parse("2015-09-11"));
	}
	public static Item getCornflakesItem() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return new Item("Corn Flakes",
						2,
						sdf.parse("2014-09-11"), 
						sdf.parse("2014-12-21"), 
						sdf.parse("2015-09-11"));
	}
	public static Item getLaysItem() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return new Item("Lays",
						3,
						sdf.parse("2014-09-11"), 
						sdf.parse("2014-12-21"), 
						sdf.parse("2015-09-11"));
	}
	
}
