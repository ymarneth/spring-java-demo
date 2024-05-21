package at.risc.springjavademo.myentity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MyEntityController.class)
class MyEntityControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MyEntityRepository myEntityRepository;

	@Test
	void getAllTests() throws Exception {
		var myEntities = List.of(new MyEntity(), new MyEntity());

		given(myEntityRepository.findAll()).willReturn(myEntities);

		mockMvc.perform(get("/api/my-entity"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)));
	}
}
