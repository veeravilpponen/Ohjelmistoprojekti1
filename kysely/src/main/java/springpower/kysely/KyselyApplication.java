package springpower.kysely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springpower.kysely.domain.Kysymys;
import springpower.kysely.domain.KysymysRepository;

@SpringBootApplication
public class KyselyApplication {
	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner kyselyDemo(KysymysRepository krepository) {
		return (args) -> {
			log.info("save questions");
			krepository.save(new Kysymys("Ikäsi?"));
			krepository.save(new Kysymys("Mitä opiskelet?"));
			krepository.save(new Kysymys("Ostatko Haaga-Helian tiloista virkistystuotteita?"));
			krepository.save(new Kysymys("Kuinka tyytyväinen olet nykyiseen Haaga-Helian virkistystuotetarjontaan?"));
			krepository.save(new Kysymys("Mitä virkistystuotteita käytät?"));
			
			log.info("fetch all questions");
			for (Kysymys kysymys : krepository.findAll()) {
				log.info(kysymys.toString());
			}
		};
	}
}
