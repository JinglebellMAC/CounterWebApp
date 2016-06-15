package ie.deloitte.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	private Map<String,Integer> revenueMap = new HashMap<String,Integer>();;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		setupMap();
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcomeName] counter : {}", counter);

		setupMap();
		
		return VIEW_INDEX;

	}
	
	private void setupMap(){
		revenueMap.put("Jan", 420000);
		revenueMap.put("Feb", 810000);
		revenueMap.put("Mar", 720000);
		revenueMap.put("Apr", 550000);
		revenueMap.put("May", 910000);
		revenueMap.put("June", 510000);
		revenueMap.put("July", 680000);
		revenueMap.put("Aug", 620000);
		revenueMap.put("Sep", 610000);
		revenueMap.put("Oct", 490000);
		revenueMap.put("Nov", 900000);
		revenueMap.put("Dec", 730000);
	}
}
