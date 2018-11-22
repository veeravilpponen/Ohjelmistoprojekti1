package springpower.kysely.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VaihtoehtoRepository extends CrudRepository <Vaihtoehto, Long> {
	
	/** Hakee vaihtoehdot kysymyksen perusteella **/
	List<Vaihtoehto> findByKysymys(Kysymys kysymys);
	
	
}