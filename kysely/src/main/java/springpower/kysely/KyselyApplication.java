package springpower.kysely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springpower.kysely.domain.Kysely;
import springpower.kysely.domain.KyselyRepository;
import springpower.kysely.domain.Kysymys;
import springpower.kysely.domain.KysymysRepository;
import springpower.kysely.domain.Vaihtoehto;
import springpower.kysely.domain.VaihtoehtoRepository;
import springpower.kysely.domain.ValittuRepository;
import springpower.kysely.domain.Vastaus;
import springpower.kysely.domain.VastausRepository;

@SpringBootApplication
public class KyselyApplication {
	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner kyselyDemo(KysymysRepository kysymysrepository, KyselyRepository kyselyrepository, VastausRepository vastausrepository, VaihtoehtoRepository vaihtoehtorepository, ValittuRepository valitturepository) {
		return (args) -> {
			log.info("save questionnaires");
			kyselyrepository.save(new Kysely("Kahvi"));
			kyselyrepository.save(new Kysely("Open"));
			
			log.info("save questions");
		
			kysymysrepository.save(new Kysymys("Minkä ikäinen olet?", "Radio", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Mitä opiskelet?", "Radio", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Ostatko Haaga-Helian tiloista kofeiinituotteita?", "Radio", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Oletko tyytyväinen nykyiseen Haaga-Helian kofeiinituotetarjontaan?", "Radio", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Mitä Haaga-Helian nykyisessä palvelussa olisi parannettavaa?", "Teksti", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Mitä kofeiinituotteita käytät?", "Checkbox", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Käytätkö jotain muita virkistystuotteita?", "Teksti", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Oletko merkkiuskollinen jollekin tietylle kofeiinivirkistystuotemerkille, mille?", "Teksti", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Kuinka paljon käytät kyseisiä tuotteita koulupäivän aikana?", "Radio", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Kuinka paljon käyttömääräsi muuttuisi, mikäli tuotteet olisivat halvempia?", "Radio", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Kofeiinituotteiden ekologisuus merkitsee minulle paljon.", "Radio", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Kofeiinituotteiden eettisyys merkitsee minulle paljon.", "Radio", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Käyttäisitkö omaa takeaway-mukia?", "Checkbox", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Haluaisitko kahvipassin, jolla saisi alennuksia tai ilmaisen kahvin tietyn ostomäärän jälkeen?", "Checkbox", kyselyrepository.findByKyselyNimi("Kahvi")));
			
			vastausrepository.save(new Vastaus("Tarvitaan edullisempaa kahvia", kysymysrepository.findByKysymysSisus("Mitä Haaga-Helian nykyisessä palvelussa olisi parannettavaa?")));
			
			vaihtoehtorepository.save(new Vaihtoehto("Alle 20", kysymysrepository.findByKysymysSisus("Minkä ikäinen olet?")));
			vaihtoehtorepository.save(new Vaihtoehto("21-25", kysymysrepository.findByKysymysSisus("Minkä ikäinen olet?")));
			vaihtoehtorepository.save(new Vaihtoehto("26-30", kysymysrepository.findByKysymysSisus("Minkä ikäinen olet?")));
			vaihtoehtorepository.save(new Vaihtoehto("31-35", kysymysrepository.findByKysymysSisus("Minkä ikäinen olet?")));
			vaihtoehtorepository.save(new Vaihtoehto("36-40", kysymysrepository.findByKysymysSisus("Minkä ikäinen olet?")));
			vaihtoehtorepository.save(new Vaihtoehto("yli 41", kysymysrepository.findByKysymysSisus("Minkä ikäinen olet?")));
			
			vaihtoehtorepository.save(new Vaihtoehto("En koskaan", kysymysrepository.findByKysymysSisus("Ostatko Haaga-Helian tiloista kofeiinituotteita?")));
			vaihtoehtorepository.save(new Vaihtoehto("Harvoin", kysymysrepository.findByKysymysSisus("Ostatko Haaga-Helian tiloista kofeiinituotteita?")));
			vaihtoehtorepository.save(new Vaihtoehto("Usein", kysymysrepository.findByKysymysSisus("Ostatko Haaga-Helian tiloista kofeiinituotteita?")));
			vaihtoehtorepository.save(new Vaihtoehto("Päivittäin", kysymysrepository.findByKysymysSisus("Ostatko Haaga-Helian tiloista kofeiinituotteita?")));
			vaihtoehtorepository.save(new Vaihtoehto("Kahvi", kysymysrepository.findByKysymysSisus("Mitä kofeiinituotteita käytät?")));
			vaihtoehtorepository.save(new Vaihtoehto("Tee", kysymysrepository.findByKysymysSisus("Mitä kofeiinituotteita käytät?")));
			vaihtoehtorepository.save(new Vaihtoehto("Limu", kysymysrepository.findByKysymysSisus("Mitä kofeiinituotteita käytät?")));
			vaihtoehtorepository.save(new Vaihtoehto("Kofeiinitabletit", kysymysrepository.findByKysymysSisus("Mitä kofeiinituotteita käytät?")));
	
			log.info("fetch all questions");
			for (Kysymys kysymys : kysymysrepository.findAll()) {
				log.info(kysymys.toString());
			}
		};
	}
}
