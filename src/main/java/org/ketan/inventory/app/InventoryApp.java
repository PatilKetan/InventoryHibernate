package org.ketan.inventory.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ketan.model.Item;
import org.ketan.model.Supplier;

public class InventoryApp {

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
			
			jack.getItemList().add(juice);
			jack.getItemList().add(cornFlakes);
			jack.getItemList().add(lays);
			
			/* this is optional
			*
			* juice.setSupplier(jack);
			* cornFlakes.setSupplier(jack);
			* lays.setSupplier(jack);
			* */
		session.getTransaction().commit();
		session.close();
		
	}

}
