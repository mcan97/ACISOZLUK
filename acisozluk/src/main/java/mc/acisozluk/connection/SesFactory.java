package mc.acisozluk.connection;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class SesFactory {
	private static SesFactory instance;
	
	private Configuration conf;
	private SessionFactory factory;
	
	private SesFactory() {
		conf = new Configuration();
		conf.configure();
		
		factory = conf.buildSessionFactory();
	}
	
	public static SessionFactory getInstance() {
		if(instance == null) instance = new SesFactory();
		
		return instance.factory;
	}
}
