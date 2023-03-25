package mc.acisozluk.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<Entry> entries;
	
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<Baslik> basliklar;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Entry> getEntries() {
		return entries;
	}
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
	public List<Baslik> getBasliklar() {
		return basliklar;
	}
	public void setBasliklar(List<Baslik> basliklar) {
		this.basliklar = basliklar;
	}
	
	
}
