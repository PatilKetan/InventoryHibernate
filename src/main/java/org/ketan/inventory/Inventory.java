package org.ketan.inventory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ketan.model.Item;
import org.ketan.model.Supplier;

public class Inventory {

	public static void main(String[] args) throws ParseException {
		//dummy items
		Item juice = Item.getJuiceItem();
		Item cornFlakes = Item.getCornflakesItem();
		Item lays = Item.getLaysItem();
		
		Supplier jack = Supplier.getJackSupplier();
		Supplier jim = Supplier.getJimSupplier();
		Supplier jonny = Supplier.getJonnySupplier();
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//*****Saving Objects to DB*****
		Session session = factory.openSession();
		session.beginTransaction();
		
			session.save(juice);
			session.save(cornFlakes);
			session.save(lays);
			
			session.save(jack);
			session.save(jim);
			session.save(jonny);
			
		session.getTransaction().commit();
		session.close();
		
		
		//*****Reading Object from DB*****
		session = factory.openSession();
		session.beginTransaction();
		
			//retreive object with id 1
			Item firstItem = session.get(Item.class, 1);
			System.out.println("Item with Id 1 : " + firstItem);
		
		session.getTransaction().commit();
		session.close();
		
		
		
		//*****Reading Object from DB*****
		session = factory.openSession();
		session.beginTransaction();
		
			List<Item> items = session.createQuery("from Item").getResultList();
			
			for (Item currentItem : items) {
				System.out.println(currentItem);
			}
		
		session.getTransaction().commit();
		session.close();
	}

}
