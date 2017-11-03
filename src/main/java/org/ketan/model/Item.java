package org.ketan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Item {
	
	@Id
	@Column(name = "Item_Id")
	private int itemId;
	
	@Column(name = "Item_Name")
	private String itemName;
	
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
	
	public Item(int itemId, String itemName, Date manufacturedDate, Date entryDate, Date expiryDate) {
		this.itemId = itemId;
		this.itemName = itemName;
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
	
}
