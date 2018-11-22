package springpower.kysely.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VaihtoehtoRepository extends CrudRepository <Vaihtoehto, Long> {
	
	List<Vaihtoehto> findByKysely(Kysymys kysymys);
	
	
}