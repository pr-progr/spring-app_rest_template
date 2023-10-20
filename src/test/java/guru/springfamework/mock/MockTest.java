package guru.springfamework.mock;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MockTest {
	
	@Mock
	List<String> mockList;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		mockList.add("test");
		Mockito.verify(mockList).add("test");
		assertEquals(0, mockList.size());

		Mockito.when(mockList.size()).thenReturn(100);
		assertEquals(100, mockList.size());

		System.out.println(mockList.get(99));
	

}
}
