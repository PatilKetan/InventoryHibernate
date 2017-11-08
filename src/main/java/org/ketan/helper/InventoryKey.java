/* This classe provides as an 
 * embedded composite key for the inventory
 *  */

package org.ketan.helper;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventoryKey implements Serializable{
	
	private static final long serialVersionUID = 17202327L;
	@Column (name = "Item_Id")
	private int itemId;
	@Column (name = "Supplier_Id")
	private int supplierId;
	
	
	public InventoryKey() {
	}
	public InventoryKey(int itemId, int supplierId) {
		this.itemId = itemId;
		this.supplierId = supplierId;
	}
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	
}
