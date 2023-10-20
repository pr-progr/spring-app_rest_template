package guru.springfamework.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import guru.springfamework.domain.Pet;
import guru.springfamework.domain.PetData;

@Service
public class ApiServiceImpl implements ApiService {
	
	private RestTemplate restTemplate;
	final String apiUri ;

	

	public ApiServiceImpl(RestTemplate restTemplate,@Value("${api.uri}") String apiUri) {
		this.restTemplate = restTemplate;
		this.apiUri = apiUri;
	}



	@Override
	public List<Pet> getPetByStatus(String status) {
		
	UriComponentsBuilder uriBuilder = UriComponentsBuilder
			.fromUriString(apiUri)
			.queryParam("status",status);
	Pet[] pet =	 restTemplate.getForObject(uriBuilder.toUriString(), Pet[].class);
	return Arrays.asList(pet);
	}
	
	



	
}
