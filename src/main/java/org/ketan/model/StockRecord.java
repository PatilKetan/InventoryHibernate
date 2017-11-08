package org.ketan.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.ketan.helper.InventoryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stock_record")
@Data
public class StockRecord {
	//itemId and SupplierId will be the combined primary key
	//this wont be a list
	@Id
	@Column(name = "stock_record_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ref_supplier")
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name = "ref_item")
	private Item item;
	
	@Column(name = "entry_date")
	private Date entryDate;
	
	@Column(name = "price")
	private Double price;

}
