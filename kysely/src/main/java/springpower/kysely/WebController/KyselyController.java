package springpower.kysely.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



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

}
