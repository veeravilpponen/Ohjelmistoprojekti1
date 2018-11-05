package springpower.kysely.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vastaus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String vastaus;
	
	
	//constructors
	public Vastaus() {
		super();
		this.vastaus = null;
	}
	
	public Vastaus(String vastaus) {
		super();
		this.vastaus = vastaus;
	}
	
	// GETTERS
	public String getVastaus() { return this.vastaus; }
	public Long getId() { return this.id; }
	
	// SETTERS
	public boolean setVastaus(String vastaus) { this.vastaus = vastaus; return true; }
	public boolean setId(Long id) { this.id = id; return true; }
}
