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
			kysymysrepository.save(new Kysymys("Ostatko Haaga-Helian tiloista kofeiinituotteita?", "Radio", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Mitä kofeiinituotteita käytät?", "Checkbox", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Mitä Haaga-Helian nykyisessä palvelussa olisi parannettavaa?", "Teksti", kyselyrepository.findByKyselyNimi("Kahvi")));


			vastausrepository.save(new Vastaus("Tarvitaan edullisempaa kahvia", kysymysrepository.findByKysymysSisus("Mitä Haaga-Helian nykyisessä palvelussa olisi parannettavaa?")));
			vastausrepository.save(new Vastaus("", kysymysrepository.findByKysymysSisus("Ostatko Haaga-Helian tiloista kofeiinituotteita?")));
			vastausrepository.save(new Vastaus("", kysymysrepository.findByKysymysSisus("Mitä kofeiinituotteita käytät?")));

			
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
