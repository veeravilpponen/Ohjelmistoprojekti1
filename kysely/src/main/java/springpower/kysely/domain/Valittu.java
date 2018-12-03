package springpower.kysely.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Valittu {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long valittuId;
	
	private String valittuSisus;
	 
	@ManyToOne
	@JoinColumn(name = "vastausId")
	@JsonIgnore
	private Vastaus vastaus;

	//Getter and Setters
	public String getValittuSisus() {
		return valittuSisus;
	}

	public void setValittuSisus(String valittuSisus) {
		this.valittuSisus = valittuSisus;
	}

	public Vastaus getVastaus() {
		return vastaus;
	}

	public void setVastaus(Vastaus vastaus) {
		this.vastaus = vastaus;
	}
	
	@Override
		public String toString() {
			return "Valittu [valittuId=" + valittuId + ", valittuSisus=" + valittuSisus + ", vastaus=" + vastaus + "]";
		}

	
}
