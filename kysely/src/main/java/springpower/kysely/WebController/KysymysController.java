package springpower.kysely.WebController;

import java.util.List;
import java.util.Optional;

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
	
	
	/** näyttää kaikki kysymykset tietokannasta **/
	@RequestMapping(value="/Kysely/kysymykset", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymysListRest() {	
        return (List<Kysymys>) kysymysRepository.findAll();
    } 
	
	/** näyttää  kysymyksen vastauksineen kysymyksen Id:n perusteella **/
	@RequestMapping(value="/Kysely/kysymykset/{kysymysId}/vastaukset", method = RequestMethod.GET)
    public @ResponseBody Optional<Kysymys> finById(@PathVariable("kysymysId") Long kysymysId)  {	
		
		Kysymys kysymys = kysymysRepository.findById(kysymysId).get();
		System.out.println("KYSYMYS" + kysymys);
		
		return kysymysRepository.findById(kysymysId );
    } 
	
	

	
	

}
