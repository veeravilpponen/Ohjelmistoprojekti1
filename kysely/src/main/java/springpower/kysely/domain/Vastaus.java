package springpower.kysely.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vastaus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String vastausSisus;
	
	 @ManyToOne
	 @JsonIgnore
	 @JoinColumn(name = "vastausId")
	 private Kysymys kysymys;
	
	public Vastaus() {
		super();
		this.vastausSisus=null;
	}
	public Vastaus(String vastausSisus) {
		super();
		this.vastausSisus=vastausSisus;
	}
	
	
	@Override
	public String toString() {
		return "Vastaus [id=" + id + ", vastausSisus=" + vastausSisus + "]";
	}
	// GETTERS
	public String getVastausSisus() { return this.vastausSisus; }
	public Long getId() { return this.id; }
	
	// SETTERS
	public void setVastausSisus(String vastausSisus) { this.vastausSisus = vastausSisus; }
	public void setId(Long id) { this.id = id; }
}
