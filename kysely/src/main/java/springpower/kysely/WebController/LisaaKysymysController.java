package springpower.kysely.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springpower.kysely.domain.KyselyRepository;
import springpower.kysely.domain.Kysymys;
import springpower.kysely.domain.KysymysRepository;
import springpower.kysely.domain.VaihtoehtoRepository;

@Controller
public class LisaaKysymysController {
	
	@Autowired
	KysymysRepository Kysymysrepository;
	@Autowired
	KyselyRepository Kyselyrepository;
	@Autowired
	VaihtoehtoRepository Vaihtoehtorepository;
    
	//LISÄÄ KYSYMYS
	@RequestMapping(value = "/lisaakysymys", method = RequestMethod.GET)
	public String lisaaKysymys(Model model) {
		model.addAttribute("kysymys", new Kysymys());
    	model.addAttribute("kyselyt", Kyselyrepository.findAll());
    	model.addAttribute("vaihtoehdot", Vaihtoehtorepository.findAll());
		return "syottosivu";
	}
	
	//TALLENNA KYSYMYS
	@RequestMapping(value = "/tallennakysymys", method = RequestMethod.POST)
    public String tallennaKysymys(Kysymys kysymys){
        Kysymysrepository.save(kysymys);
        return "redirect:syottosivu";
    }
}
