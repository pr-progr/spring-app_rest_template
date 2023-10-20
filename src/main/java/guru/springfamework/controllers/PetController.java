package guru.springfamework.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

import guru.springfamework.service.ApiService;

@Controller
public class PetController {

	private final ApiService apiService;

	

	public PetController(ApiService apiService,@Value("${api.uri}") String apiUri) {
		this.apiService = apiService;
	}

	@GetMapping({"","/","index"})
	public String index() {
		return "index";
	}
	
	@PostMapping("/users")
	public String getPets(Model model , ServerWebExchange serverWebExchange){
		MultiValueMap<String, String> map= serverWebExchange.getFormData().block();
		String state = map.get("state").get(0);
		
		if(state == null || "".equals(state)) {
			state ="available";
		}
		
		model.addAttribute("pets", apiService.getPetByStatus(state));
		
		return "petlist";
		
	}
	
}
