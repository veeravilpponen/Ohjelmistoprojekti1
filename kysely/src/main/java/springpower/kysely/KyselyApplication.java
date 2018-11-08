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
import springpower.kysely.domain.Vastaus;
import springpower.kysely.domain.VastausRepository;

@SpringBootApplication
public class KyselyApplication {
	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner kyselyDemo(KysymysRepository kysymysrepository, KyselyRepository kyselyrepository, VastausRepository vastausrepository) {
		return (args) -> {
			log.info("save questionnaires");
			kyselyrepository.save(new Kysely("Kahvi"));
			kyselyrepository.save(new Kysely("Open"));
			
			log.info("save questions");
			kysymysrepository.save(new Kysymys("Ikäsi?", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Mitä opiskelet?", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Ostatko Haaga-Helian tiloista virkistystuotteita?", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Kuinka tyytyväinen olet nykyiseen Haaga-Helian virkistystuotetarjontaan?", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Mitä virkistystuotteita käytät?", kyselyrepository.findByKyselyNimi("Kahvi")));
			kysymysrepository.save(new Kysymys("Testikysymys", kyselyrepository.findByKyselyNimi("Open")));


			vastausrepository.save(new Vastaus("Ohjelmistotuotantoa",kysymysrepository.findByQuestion("Mitä opiskelet?")));
			
			log.info("fetch all questions");
			for (Kysymys kysymys : kysymysrepository.findAll()) {
				log.info(kysymys.toString());
			}
		};
	}
}
