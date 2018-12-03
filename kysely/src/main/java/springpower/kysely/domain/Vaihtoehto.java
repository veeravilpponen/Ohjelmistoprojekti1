package springpower.kysely.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Vaihtoehto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vaihtoehtoId;
	
    private String vaihtoehtoSisus;
	
	@ManyToOne
	@JoinColumn(name = "kysymysId")
	@JsonBackReference
	private Kysymys kysymys;
	 
	/* siirretty valittu luokkaan
	 * @ManyToOne
	 @JoinColumn(name = "vastausId")
	 @JsonIgnore
	 private Vastaus vastaus;*/
	 
	public Vaihtoehto() {
		super();
		this.setVaihtoehtoSisus(null);
	}
	
	public Vaihtoehto(String vaihtoehtoSisus) {
		super();
		this.setVaihtoehtoSisus(vaihtoehtoSisus);
	}
	
	public Vaihtoehto(String vaihtoehtoSisus, Kysymys kysymys) {
		super();
		this.setVaihtoehtoSisus(vaihtoehtoSisus);
		this.kysymys = kysymys;
	}
		
	public Vaihtoehto(String vaihtoehtoSisus, Kysymys kysymys, Vastaus vastaus) {
		super();
		this.setVaihtoehtoSisus(vaihtoehtoSisus);
		this.kysymys = kysymys;
	}

	public String getVaihtoehtoSisus() {
		return vaihtoehtoSisus;
	}

	public void setVaihtoehtoSisus(String vaihtoehtoSisus) {
		this.vaihtoehtoSisus = vaihtoehtoSisus;
	}

}
