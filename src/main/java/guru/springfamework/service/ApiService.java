package guru.springfamework.service;

import java.util.List;

import guru.springfamework.domain.Pet;

public interface ApiService {
	
	List<Pet> getPetByStatus(String status);

}
