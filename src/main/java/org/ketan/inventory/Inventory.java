package org.ketan.inventory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ketan.model.Item;

public class Inventory {

	public static void main(String[] args) {
		Item item = new Item();
		item.setItemId(0);
		item.setItemName("ItemOne");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(item);
		
		session.getTransaction().commit();

	}

}
