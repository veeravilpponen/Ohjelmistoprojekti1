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
import springpower.kysely.domain.Vastaus;
import springpower.kysely.domain.VastausRepository;

@SpringBootApplication
public class KyselyApplication {
	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner kyselyDemo(KysymysRepository kysymysrepository, KyselyRepository kyselyrepository, VastausRepository vastausrepository, VaihtoehtoRepository vaihtoehtorepository) {
		return (args) -> {
			log.info("save questionnaires");
			kyselyrepository.save(new Kysely("Kahvi"));
			kyselyrepository.save(new Kysely("Open"));
			
			log.info("save questions");
			kysymysrepository.save(new Kysymys("Mitä Haaga-Helian nykyisessä palvelussa olisi parannettavaa?", "Teksti", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Käytätkö jotain muita virkistystuotteita?", "Valinta", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Oletko merkkiuskollinen jollekin tietylle kofeiini- virkistystuotemerkille, mille?", "Teksti", kyselyrepository.findByKyselyNimi("Kahvi")));

			
			vaihtoehtorepository.save(new Vaihtoehto("En koskaan", kysymysrepository.findByQuestion("Ostatko Haaga-Helian tiloista kofeiinituotteita?")));
			vaihtoehtorepository.save(new Vaihtoehto("Harvoin", kysymysrepository.findByQuestion("Ostatko Haaga-Helian tiloista kofeiinituotteita?")));
			vaihtoehtorepository.save(new Vaihtoehto("Usein", kysymysrepository.findByQuestion("Ostatko Haaga-Helian tiloista kofeiinituotteita?")));
			vaihtoehtorepository.save(new Vaihtoehto("Päivittäin", kysymysrepository.findByQuestion("Ostatko Haaga-Helian tiloista kofeiinituotteita?")));
			vaihtoehtorepository.save(new Vaihtoehto("Kahvi", kysymysrepository.findByQuestion("Mitä kofeiinituotteita käytät?")));
			vaihtoehtorepository.save(new Vaihtoehto("Tee", kysymysrepository.findByQuestion("Mitä kofeiinituotteita käytät?")));
			vaihtoehtorepository.save(new Vaihtoehto("Limu", kysymysrepository.findByQuestion("Mitä kofeiinituotteita käytät?")));
			vaihtoehtorepository.save(new Vaihtoehto("Kofeiinitabletit", kysymysrepository.findByQuestion("Mitä kofeiinituotteita käytät?")));
			
			
			vastausrepository.save(new Vastaus("On", kysymysrepository.findByQuestion("Mitä Haaga-Helian nykyisessä palvelussa olisi parannettavaa?")));
			vastausrepository.save(new Vastaus("Ei", kysymysrepository.findByQuestion("Mitä Haaga-Helian nykyisessä palvelussa olisi parannettavaa?")));
			vastausrepository.save(new Vastaus("Ehkä", kysymysrepository.findByQuestion("Mitä Haaga-Helian nykyisessä palvelussa olisi parannettavaa?")));
			vastausrepository.save(new Vastaus("En", kysymysrepository.findByQuestion("Käytätkö jotain muita virkistystuotteita?")));
			vastausrepository.save(new Vastaus("Kyllä", kysymysrepository.findByQuestion("Käytätkö jotain muita virkistystuotteita?")));
			
		
	
			log.info("fetch all questions");
			for (Kysymys kysymys : kysymysrepository.findAll()) {
				log.info(kysymys.toString());
			}
		};
	}
}
