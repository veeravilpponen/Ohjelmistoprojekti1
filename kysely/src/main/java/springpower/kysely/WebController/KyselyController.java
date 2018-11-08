package springpower.kysely.WebController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springpower.kysely.domain.Kysely;
import springpower.kysely.domain.KyselyRepository;
import springpower.kysely.domain.Kysymys;



@CrossOrigin
@Controller
public class KyselyController {
	
	// tuodaan KyselyRepository controllerin käyttöön
	// private KysymysRepository kysymysRepository;
    
    // palauttaa infosivun
	@GetMapping({"/info", "/"})
	public String info(Model model) {
		
		return "info";
	}
	
	@Autowired
	private KyselyRepository kyselyRepository;
	
	@RequestMapping(value="/kyselyt", method = RequestMethod.GET)
    public @ResponseBody List<Kysely> kyselyListRest() {	
        return (List<Kysely>) kyselyRepository.findAll();
    } 

}
