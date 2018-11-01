package springpower.kysely.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class VastausController {
	
	
	// @Autowired
	// private KysymysRepository kysymysRepository;
	
	@GetMapping("/vastaus")
	public String vastaus(Model model) {
		return "filler";
	}
}
