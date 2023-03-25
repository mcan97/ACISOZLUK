package mc.acisozluk.repository;

import mc.acisozluk.connection.SesFactory;
import mc.acisozluk.model.Baslik;
import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.*;


public class BaslikRepository {

	private SessionFactory factory = SesFactory.getInstance();
	
	public void save(Baslik baslik) {
		Session ses = factory.openSession();
		ses.getTransaction().begin();
		ses.persist(baslik);
		ses.getTransaction().commit();
		ses.close();
	}

	public List<Baslik> findAll() {
		Session ses = factory.openSession();
		String q = "FROM Baslik";
		Query<Baslik> query = ses.createQuery(q);
		List<Baslik> basliklar = query.getResultList();
		ses.close();
		return basliklar;
	}
}
