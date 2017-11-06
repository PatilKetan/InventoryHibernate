package org.ketan.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.ketan.helper.InventoryKey;

@Entity
public class Inventory {
	//itemId and SupplierId will be the combined primary key
	//this wont be a list
	@EmbeddedId
	private InventoryKey id;
	@Column (name = "Entry_date")
	private Date entryDate;
	@Column (name = "Warehouse_Number")
	private String warehouseNumber;
	
	
	public Inventory() {
	}
	public Inventory(InventoryKey id, Date entryDate, String warehouseNumber) {
		this.id = id;
		this.entryDate = entryDate;
		this.warehouseNumber = warehouseNumber;
	}
	
	public InventoryKey getId() {
		return id;
	}
	public void setId(InventoryKey id) {
		this.id = id;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getWarehouseNumber() {
		return warehouseNumber;
	}
	public void setWarehouseNumber(String warehouseNumber) {
		this.warehouseNumber = warehouseNumber;
	}
	

}
