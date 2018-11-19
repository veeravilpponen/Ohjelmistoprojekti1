package springpower.kysely.WebController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class KyselyController {
	
	// Autowired repositories
	@Autowired
	private KyselyRepository kyselyRepository;
	
	@Autowired
	private KysymysRepository kysymysRepository;
    
    // palauttaa infosivun
	@GetMapping({"/Kysely/info", "/"})
	public String info(Model model) {
		
		return "info";
	}
	
	/** näyttää kaikki kyselyt tietokannasta **/
	@RequestMapping(value="/Kysely/kyselyt", method = RequestMethod.GET)
    public @ResponseBody List<Kysely> kyselyListRest() {	
        return (List<Kysely>) kyselyRepository.findAll();
    }
	/** näyttää kyselyn kysymykset kyselyn nimen perusteella **/
	@RequestMapping(value="/Kysely/kyselyt/{kyselyNimi}", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymysById(@PathVariable("kyselyNimi") String kyselyNimi)  {	
		
		Kysely kysely = kyselyRepository.findByKyselyNimi(kyselyNimi);
		
		return kysymysRepository.findByKysely(kysely );
    } 
	
	/** näyttää kaikki kysymykset kysely Id:n perusteella **/
	/*@RequestMapping(value="/kyselyt/{kyselyId}/kysymykset", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymysById(@PathVariable("kyselyId") Long kyselyId)  {	
		
		Kysely kysely = kyselyRepository.findById(kyselyId).get();
		
		return (List<Kysymys>) kysymysRepository.findByKysely(kysely );
    } */
	
	/** näyttää kaikki kysymykset kysely Id:n perusteella **/
	@RequestMapping(value="/Kysely/kyselyt/{kyselyId}/kysymykset", method = RequestMethod.GET)
    public @ResponseBody Optional<Kysely> finById(@PathVariable("kyselyId") Long kyselyId)  {	
		
		Kysely kysely = kyselyRepository.findById(kyselyId).get();
		System.out.println("KYSELY" + kysely);
		
		return kyselyRepository.findById(kyselyId );
    } 

}
