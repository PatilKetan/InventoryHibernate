package org.ketan.inventory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ketan.model.Item;

public class Inventory {

	public static void main(String[] args) throws ParseException {
		Item item = new Item();
		Item item1 = new Item();
		Item item2 = new Item();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		item.setItemId(0);
		item.setItemName("juice");
		item.setManufacturedDate(sdf.parse("2014-09-11"));
		item.setEntryDate(sdf.parse("2014-12-21"));
		item.setExpiryDate(sdf.parse("2015-09-11"));
		
		item1.setItemId(1);
		item1.setItemName("cornflakes");
		item1.setManufacturedDate(sdf.parse("2014-04-10"));
		item1.setEntryDate(sdf.parse("2014-05-01"));
		item1.setExpiryDate(sdf.parse("2015-04-10"));
		
		item2.setItemId(2);
		item2.setItemName("lays");
		item2.setManufacturedDate(sdf.parse("2014-09-11"));
		item2.setEntryDate(sdf.parse("2015-12-21"));
		item2.setExpiryDate(sdf.parse("2016-09-11"));
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(item);
		session.save(item1);
		session.save(item2);
		
		session.getTransaction().commit();

	}

}
