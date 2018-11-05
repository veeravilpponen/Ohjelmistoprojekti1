package springpower.kysely.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KyselyRepository extends CrudRepository <Kysely, Long> {

	List<Kysely> findByKyselyNimi(String kysely);
	
}
