package springpower.kysely.domain;




import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KyselyRepository extends CrudRepository <Kysely, Long> {

	Kysely findByKyselyNimi(@Param(value="kysely") String kysely);
	
	
	
}
