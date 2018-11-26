package springpower.kysely.WebController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springpower.kysely.domain.Kysely;
import springpower.kysely.domain.Kysymys;
import springpower.kysely.domain.KysymysRepository;
import springpower.kysely.domain.Valittu;
import springpower.kysely.domain.ValittuRepository;
import springpower.kysely.domain.Vastaus;
import springpower.kysely.domain.VastausRepository;


@CrossOrigin
@Controller
public class VastausController {
	
	@Autowired
	private VastausRepository vastausRepository;
	
	@Autowired
	private KysymysRepository kysymysRepository;
	
	
	@Autowired
	private ValittuRepository valittuRepository;
	
	/** näyttää kaikki kaikki vastaukset tietokannasta**/
	// pitäisi olla /kysely/{id}/kysymykset/{id}/vastaukset
	 @RequestMapping(value="/vastaukset", method = RequestMethod.GET)
	    public @ResponseBody List<Vastaus> vastausListRest() {	
	        return (List<Vastaus>) vastausRepository.findAll();
	    } 
	
	 /** Vastauksen tallentaminen **/
	 // tallentaa vastauksen mutta ei saa kysymysId:tä mukaan
    @RequestMapping(value="/vastaukset", method =  RequestMethod.POST )
    public @ResponseBody Vastaus saveVastaus(@RequestBody Vastaus vastaus){
    	
    	vastausRepository.save(vastaus);
    	
    	return vastaus;
    }
    
    /** tallentaa vastauksen tietylle kysymykselle kysymyksen Id:n persuteella **/
    @RequestMapping(value="/kysymykset/{kysymysId}/vastaus", method =  RequestMethod.POST )
    public @ResponseBody Vastaus tallennaVastaus(@PathVariable long kysymysId,@RequestBody Vastaus vastaus){
    
    	Kysymys kysymys = kysymysRepository.findById(kysymysId).get();
    	System.out.println("VASTAUKSEN KYSYMYS " + kysymys);
    	
    	vastaus.setKysymys(kysymys);
    	vastausRepository.save(vastaus);
    	System.out.println("VASTAUS " + vastaus);
    	
    	// EI VIELÄ TESTATTU
    	// jos monivalintavastaus tallennetaan valitut kantaan rating.setBeer(beer);
    	List<Valittu> valitut = vastaus.getValitutVastaukset();
    	System.out.println("Valitut VASTAUKSET!" + valitut);
    	
    	// for loop tallennusta varten?
    	for(int i = 0; i< valitut.size(); i++) {
    	
    		Valittu valittu = valitut.get(i);
    		valittu.setVastaus(vastaus);
    		valittuRepository.save(valittu);
    		System.out.println("INDEX!!"+valitut.get(i));
    	};
    	return vastaus;
    
        }

    
    
    /** näyttää kaikki  kysymyksen vastaukset kysymyksen Id:n perusteella **/
	@RequestMapping(value="/kysymykset/{kysymysId}", method = RequestMethod.GET)
    public @ResponseBody List<Vastaus> kysymysById(@PathVariable("kysymysId") Long kysymysId)  {	
		
		System.out.println("KYSYMYSID!!!" + kysymysId);
		
		System.out.println(kysymysRepository.findById(kysymysId));
		
		Kysymys kysymys = kysymysRepository.findById(kysymysId).get();
		System.out.println("KYSYMYS" + kysymys);
		
		return (List<Vastaus>) vastausRepository.findByKysymys(kysymys);
    } 
}
