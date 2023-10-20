package guru.springfamework.domain;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PetData {
	
	List<Pet> getData;

	public List<Pet> getGetData() {
		return getData;
	}

	public void setGetData(List<Pet> getData) {
		this.getData = getData;
	}

}
