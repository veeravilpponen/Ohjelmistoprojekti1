package springpower.kysely.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Kysely {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kyselyId;
	
	private String kyselyNimi;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
	private List<Kysymys> kysymykset;

	public Kysely() {
		
	}
	
	public Kysely(String kyselyNimi) {
		super();
		this.kyselyNimi = kyselyNimi;
	}
	
	public String getKyselyNimi() {
		return kyselyNimi;
	}

	public void setKyselyNimi(String kyselyNimi) {
		this.kyselyNimi = kyselyNimi;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}

	@Override
	public String toString() {
		return "Kysely [kyselyId=" + kyselyId + ", kyselyNimi=" + kyselyNimi + ", kysymykset=" + kysymykset + "]";
	}

	
	
	
}
