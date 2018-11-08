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

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long kysymysId;
	
	private String question;
	
	
	 @ManyToOne
	 @JsonIgnore
	 @JoinColumn(name = "kyselyId")
	 private Kysely kysely;
	 
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vastaus> vastaukset;
	
	//constructors
	public Kysymys() {
		super();
		this.question = null;
	}
	
	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}

	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}

	public Kysymys(String question) {
		super();
		this.question = question;
	}
	
	
	public Kysymys(String question, Kysely kysely) {
		super();
		this.question = question;
		this.kysely = kysely;
	}

	

	//getters and setters
	
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
			return "Kysymys [kysymysId=" + kysymysId + ", question=" + question + ", kysely=" + kysely + "]";
		else return "Kysymys [kysymysId=" + kysymysId + ", question=" + question;
	}


	
	
	

}
