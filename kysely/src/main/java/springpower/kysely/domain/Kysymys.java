package springpower.kysely.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long id;
	
	private String question;
	
	//constructors
	public Kysymys() {
		super();
		this.question = null;
	}
	
	
	public Kysymys(String question) {
		super();
		this.question = question;
	}

	//getters and setters
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
		return "Kysymys [id=" + id + ", question=" + question + "]";
	}
	
	

}
