package springpower.kysely.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long id;
	
	private String question;
	
	
	 @ManyToOne
	 @JsonIgnore
	 @JoinColumn(name = "kyselyId")
	 private Kysely kysely;
	
	//constructors
	public Kysymys() {
		super();
		this.question = null;
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

	
	public Long getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	@Override
	public String toString() {
		if(this.kysely != null) 
			return "Kysymys [id=" + id + ", question=" + question + ", kysely=" + kysely + "]";
		else return "Kysymys [id=" + id + ", question=" + question;
	}


	
	
	

}
