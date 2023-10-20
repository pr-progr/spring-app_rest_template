package guru.springfamework.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springfamework.domain.Pet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

	@Autowired
	ApiService apiService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetPetByStatus() {
		List<Pet> listPet = apiService.getPetByStatus("sold");
		assertEquals( "sold", listPet.get(0).getStatus());
	}

}
