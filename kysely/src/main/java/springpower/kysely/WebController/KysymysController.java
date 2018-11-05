package springpower.kysely.WebController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springpower.kysely.domain.Kysymys;
import springpower.kysely.domain.KysymysRepository;

@CrossOrigin
@Controller
public class KysymysController {
	
	@Autowired
	private KysymysRepository kysymysRepository;
	
	@RequestMapping(value="/kysymykset", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymysListRest() {	
        return (List<Kysymys>) kysymysRepository.findAll();
    } 
	
	/** näyttää kysymykset kysely Id:n perusteella **/
	/*@RequestMapping(value="/kyselyt/{kyselyId}", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymysById(@PathVariable("kyselyId") Long kyselyId)  {	
        return (List<Kysymys>) kysymysRepository.findById(kyselyId);
    } */
	
}
