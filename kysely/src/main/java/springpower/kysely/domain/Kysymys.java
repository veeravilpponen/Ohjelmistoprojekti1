package springpower.kysely.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kysymysId;
	
	private String question;
	private String kysymysTyyppi;
	
	 
	 @ManyToOne
	 @JoinColumn(name = "kyselyId")
	 @JsonBackReference
	 private Kysely kysely;
	 
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	@JsonManagedReference
	private List<Vastaus> vastaukset;
	
	//constructors
	public Kysymys() {
		super();
		this.question = null;
		this.kysymysTyyppi = null;
	}
	
	public Kysymys(String question, String kysymysTyyppi) {
		super();
		this.question = question;
		this.kysymysTyyppi = kysymysTyyppi;
	}
	
	public Kysymys(String question, String kysymysTyyppi, Kysely kysely) {
		super();
		this.question = question;
		this.kysymysTyyppi = kysymysTyyppi;
		this.kysely = kysely;
	}

	

	//getters and setters
	
	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}

	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	
	public String getKysymysTyyppi() {
		return kysymysTyyppi;
	}

	public void setKysymysTyyppi(String kysymysTyyppi) {
		this.kysymysTyyppi = kysymysTyyppi;
	}

	public Kysely getKysely() {
		return kysely;
	}


	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}

	
	public Long getKysymysId() {
		return kysymysId;
	}

	public String getQuestion() {
		return question;
	}


	public void setKysymyId(Long kysymysId) {
		this.kysymysId = kysymysId;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	@Override
	public String toString() {
		if(this.kysely != null) 
			return "Kysymys [kysymysId=" + kysymysId + ", question=" + question + ", kysymysTyyppi=" + kysymysTyyppi + ", kysely=" + kysely + "]";
		else return "Kysymys [kysymysId=" + kysymysId + ", question=" + question + ", kysymysTyyppi=" + kysymysTyyppi;
	}


	
	
	

}
