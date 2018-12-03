package springpower.kysely.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Kysymystyyppi {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kysymystyyppiId;
	
	private String kysymystyyppiNimi;
	
	@ManyToOne
	@JoinColumn(name = "kysymysId")
	@JsonBackReference
	private Kysymys kysymys;

	public Kysymystyyppi() {
		super();
		this.kysymystyyppiNimi = null;
	}
	
	public Kysymystyyppi(String kysymystyyppiNimi) {
		super();
		this.kysymystyyppiNimi = kysymystyyppiNimi;
	}

	public Long getKysymystyyppiId() {
		return kysymystyyppiId;
	}

	public void setKysymystyyppiId(Long kysymystyyppiId) {
		this.kysymystyyppiId = kysymystyyppiId;
	}

	public String getKysymystyyppiNimi() {
		return kysymystyyppiNimi;
	}

	public void setKysymystyyppiNimi(String kysymystyyppiNimi) {
		this.kysymystyyppiNimi = kysymystyyppiNimi;
	}

	@Override
	public String toString() {
		return "Kysymystyyppi [kysymystyyppiId=" + kysymystyyppiId + ", kysymystyyppiNimi=" + kysymystyyppiNimi
				+ ", kysymys=" + kysymys + "]";
	}
	
}
