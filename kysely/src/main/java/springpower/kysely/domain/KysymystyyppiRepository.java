package springpower.kysely.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KysymystyyppiRepository extends CrudRepository <Kysymystyyppi, Long> {

	Kysymystyyppi findByKysymystyyppiNimi(@Param(value="kysymystyyppi") String kysymystyyppi);

}

