
package org.ketan.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@Data
public class Item {
	
	@Id
	@Column(name = "Item_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	
	@Column(name = "Item_Name")
	private String itemName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Manufactured_Date")
	private Date manufacturedDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Expiry_Date")
	private Date expiryDate;
	
	@OneToMany(mappedBy = "item")
	private List<StockRecord> items = new ArrayList<StockRecord>();
	
	
	
//	
//	Dummy DUMB static object factories
//	public static Item getJuiceItem() throws ParseException{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		return new Item(1,"juice",
//						sdf.parse("2014-09-11"),
//						sdf.parse("2015-09-11"));
//	}
//	public static Item getCornflakesItem() throws ParseException{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		return new Item(2,"Corn Flakes",
//						sdf.parse("2014-12-21"), 
//						sdf.parse("2015-09-11"));
//	}
//	public static Item getLaysItem() throws ParseException{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		return new Item(3,"Lays",
//						sdf.parse("2014-12-21"), 
//						sdf.parse("2015-09-11"));
//	}
	
}
