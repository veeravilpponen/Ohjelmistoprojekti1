package springpower.kysely.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Vastaus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vastausId;
	
	private String vastausSisus;

	 @ManyToOne
	 @JoinColumn(name = "kysymysId")
	 @JsonBackReference
	 private Kysymys kysymys;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaihtoehto")
	private List<Vaihtoehto> valitutVastaukset;
	
	public Vastaus() {
		super();
		this.vastausSisus=null;
	}
	public Vastaus(String vastausSisus) {
		super();
		this.vastausSisus=vastausSisus;
	}
	
	public Vastaus(String vastausSisus, Kysymys kysymys) {
		super();
		this.vastausSisus=vastausSisus;
		this.kysymys = kysymys;
	}

	// GETTERS
	public String getVastausSisus() { return this.vastausSisus; }
	public Long getVastausId() { return this.vastausId; }
	public Kysymys getKysymys() {return kysymys;}
	
	// SETTERS
	public void setVastausSisus(String vastausSisus) { this.vastausSisus = vastausSisus; }
	public void setVastausId(Long vastausId) { this.vastausId = vastausId; }
	public void setKysymys(Kysymys kysymys) {this.kysymys = kysymys;}
	
	@Override
	public String toString() {
		if(this.kysymys != null) 
		return "Vastaus [vastausId=" + vastausId + ", vastausSisus=" + vastausSisus + ", kysymys=" + kysymys + "]";
		else return "Vastaus [vastausId=" + vastausId + ", vastausSisus=" + vastausSisus + "]";
	}
}

