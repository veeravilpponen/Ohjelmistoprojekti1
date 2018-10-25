package springpower.kysely.WebController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class KyselyController {
	
	/**  tuodaan KyselyRepository controllerin käyttöön**/
	@Autowired
	private KyselyRepository kyselyRepository;
	
	
	/** RESTful service to get all kysymykset **/
    @RequestMapping(value="/kysymykset", method = RequestMethod.GET)
    public @ResponseBody List<kysymys> studentListRest() {	
        return (List<Kysymys>) kysymysRepository.findAll();
    } 

}
