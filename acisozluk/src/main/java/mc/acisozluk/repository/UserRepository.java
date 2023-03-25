package mc.acisozluk.repository;
import mc.acisozluk.connection.SesFactory;
import org.hibernate.*;
import org.hibernate.query.*;

import mc.acisozluk.model.User;

public class UserRepository {

	
	private SessionFactory factory = SesFactory.getInstance();
	
	public boolean isUnique(String username) {
		Session ses = factory.openSession();
		
		String q = "SELECT COUNT(*) FROM User WHERE username = :username ";
		
		Query<Long> query = ses.createQuery(q);
		query.setParameter("username", username);
		long result = query.getSingleResult();
		ses.close();
		return result < 1;
	}

	public void save(User user) {
		Session ses = factory.openSession();
		ses.getTransaction().begin();
		ses.persist(user);
		ses.getTransaction().commit();
		ses.close();
	}

	public boolean checkUser(String username) {
		
		return !isUnique(username);
	}

	public boolean checkPassword(String username, String password) {
		User user = findByUsername(username);
		
		return user.getPassword().equals(password);
	}
	
	public User findByUsername(String username) {
		Session ses = factory.openSession();
		Query<User> query = ses.createQuery(" FROM User WHERE username = :username");
		query.setParameter("username", username);
		User user = query.getSingleResult();
		ses.close();
		return user;
	}
	
}
