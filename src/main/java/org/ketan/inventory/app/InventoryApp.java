package org.ketan.inventory.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ketan.helper.Address;
import org.ketan.model.Item;
import org.ketan.model.StockRecord;
import org.ketan.model.Supplier;

public class InventoryApp {

	public static void main(String[] args) throws ParseException {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		Item item1 = new Item();
		Item item2 = new Item();
		
		item1.setItemId(101);
		item1.setItemName("Toblerone");
		item1.setManufacturedDate(sdf.parse("2014-09-11"));
		item1.setExpiryDate(sdf.parse("2015-09-11"));
		
		item2.setItemId(102);
		item2.setItemName("Bounty");
		item2.setManufacturedDate(sdf.parse("2014-09-11"));
		item2.setExpiryDate(sdf.parse("2015-09-11"));
		
		Supplier supplier1 = new Supplier();
		Supplier supplier2 = new Supplier();
		
		supplier1.setSupplierId(1);
		supplier1.setSuppliername("Walmart");
		supplier1.setSupplieraddress(new Address("Pune","411044"));
		
		supplier2.setSupplierId(2);
		supplier2.setSuppliername("Roka");
		supplier2.setSupplieraddress(new Address("Chennai","420085"));
		
		StockRecord stockRecord1 = new StockRecord();
		StockRecord stockRecord2 = new StockRecord();
		
		stockRecord1.setId(1);
		stockRecord1.setItem(item1);
		stockRecord1.setSupplier(supplier1);
		stockRecord1.setPrice(100.00);
		stockRecord1.setEntryDate(sdf.parse("2014-10-11"));
		
		
		stockRecord2.setId(2);
		stockRecord2.setItem(item2);
		stockRecord2.setSupplier(supplier1);
		stockRecord2.setPrice(200.00);
		stockRecord2.setEntryDate(sdf.parse("2014-10-11"));
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//*****Saving Objects to DB*****
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(item1);
		session.save(item2);
			
		session.save(supplier1);
		session.save(supplier2);
		
		session.save(stockRecord1);
		session.save(stockRecord2);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
