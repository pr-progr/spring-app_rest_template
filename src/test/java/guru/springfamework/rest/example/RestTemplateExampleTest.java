/**
 * 
 */
package guru.springfamework.rest.example;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;

import guru.springfamework.domain.Pet;

/**
 * @author pasqu
 *
 */
public class RestTemplateExampleTest {

	public static final String API_ROOT ="https://petstore3.swagger.io/api/v3";

	@Test
	public void test() {
		String apiUri = API_ROOT + "/pet/findByStatus";
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromUriString(apiUri)
				.queryParam("status", "sold");
		JsonNode jsonNode =restTemplate.getForObject(builder.toUriString(), JsonNode.class);
		System.out.println("Respose");
		System.out.println(jsonNode.toString());
	}
	
	@Test
	public void Test2() {
		String apiUri = API_ROOT + "/pet";
		Map <String,Object> postMap = new HashMap<>();
		postMap.put("id", "100");
		postMap.put("name","test_g");
		postMap.putIfAbsent("status", "sold");
		
		RestTemplate restTemplate = new RestTemplate();
		JsonNode jsonNode = restTemplate.postForObject(apiUri, postMap, JsonNode.class);
		System.out.println("Respose");
		System.out.println(jsonNode.toString());
	}

}
