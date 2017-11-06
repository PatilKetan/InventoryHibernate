package org.ketan.demo;

import javax.persistence.ElementCollection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProxyDemo {
	 
	public static void main(String[] args) {
		Proxy proxy = new Proxy();
		proxy.setId(1);
		proxy.getProxyList().add("This");
		proxy.getProxyList().add("is");
		proxy.getProxyList().add("a");
		proxy.getProxyList().add("test");
		proxy.getProxyList().add("for");
		proxy.getProxyList().add("Lazy Initialization");
		proxy.getProxyList().add("and");
		proxy.getProxyList().add("Proxy Objects");
		
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//*****Saving Objects to DB*****
		Session session = factory.openSession();
		session.beginTransaction();
		
			session.save(proxy);
			
			proxy = null;
			proxy = session.get(Proxy.class, 1);
			
			/* System.out.println(proxy);
			 *  
			 * proxy object returned here wont have
			 * the internal collection due to lazy initialization & 
			 * will just return a dummy(proxy) object 
			 * which wont have the collection as its part
			 * 
			 * */
			
			/* proxy.getProxyList();
			 * 
			 * this will fetch all the values (Collection)
			 * from the database
			 * 
			 * */
			
			/* to change this behavior add
			 * @ElementCollection(fetch = FetchType.EAGER)
			 * */
			
			
		session.getTransaction().commit();
		session.close();
		
		 
	}

}
