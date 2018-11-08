package springpower.kysely.WebController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springpower.kysely.domain.Kysymys;
import springpower.kysely.domain.Vastaus;
import springpower.kysely.domain.VastausRepository;


@CrossOrigin
@Controller
public class VastausController {
	
	@Autowired
	private VastausRepository vastausRepository;
		
	 @RequestMapping(value="/vastaukset", method = RequestMethod.GET)
	    public @ResponseBody List<Vastaus> vastausListRest() {	
	        return (List<Vastaus>) vastausRepository.findAll();
	    } 
	
	 /** Vastauksen tallentaminen **/
    @RequestMapping(value="/vastaukset", method =  RequestMethod.POST )
    public @ResponseBody Vastaus saveVastaus(@RequestBody Vastaus vastaus){
    	vastausRepository.save(vastaus);
    	
    	return vastaus;
    }
}
