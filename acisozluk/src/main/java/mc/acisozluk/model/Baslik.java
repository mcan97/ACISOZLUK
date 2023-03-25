package mc.acisozluk.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "basliklar")
public class Baslik {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String isim;
	
	@OneToMany(mappedBy = "baslik", fetch = FetchType.EAGER)
	private List<Entry> entries;
	
	@ManyToOne
	private User author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	
}
