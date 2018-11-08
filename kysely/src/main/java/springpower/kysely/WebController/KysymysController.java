package springpower.kysely.WebController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springpower.kysely.domain.Kysely;
import springpower.kysely.domain.KyselyRepository;
import springpower.kysely.domain.Kysymys;
import springpower.kysely.domain.KysymysRepository;



@CrossOrigin
@Controller
public class KysymysController {
	
	@Autowired
	private KysymysRepository kysymysRepository;
	
	@Autowired
	private KyselyRepository kyselyRepository;
	
	@RequestMapping(value="/kysymykset", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymysListRest() {	
        return (List<Kysymys>) kysymysRepository.findAll();
    } 
	
	/** näyttää kaikki kysymykset kysely Id:n perusteella **/
/*	@RequestMapping(value="/kysely/{kyselyId}", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymysById(@PathVariable("kyselyId") Long kyselyId)  {	
		
		Kysely kysely = kyselyRepository.findById(kyselyId).get();
		
		return (List<Kysymys>) kysymysRepository.findByKysely(kysely );
    } */
	
	/** näyttää kaikki kysymykset kysely nimen perusteella **/
	@RequestMapping(value="/kysely/{kyselyNimi}", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymysById(@PathVariable("kyselyNimi") String kyselyNimi)  {	
		
		Kysely kysely = kyselyRepository.findByKyselyNimi(kyselyNimi);
		
		return kysymysRepository.findByKysely(kysely );
    } 

}
