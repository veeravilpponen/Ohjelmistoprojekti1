package springpower.kysely.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface KysymysRepository extends CrudRepository <Kysymys, Long> {

	List<Kysymys> findByKysely(Kysely kysely);

	Kysymys findByKysymysSisus(@Param(value="kysymysSisus") String kysymysSisus);
	

}
