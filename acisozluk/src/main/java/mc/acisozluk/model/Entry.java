package mc.acisozluk.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entries")
public class Entry {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String body;
	
	@ManyToOne  
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private User author;
	
	@ManyToOne 
	private Baslik baslik;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Baslik getBaslik() {
		return baslik;
	}

	public void setBaslik(Baslik baslik) {
		this.baslik = baslik;
	}
	
	
}
