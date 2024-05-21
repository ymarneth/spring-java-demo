package at.risc.springjavademo.myentity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/my-entity")
class MyEntityController {

	private final MyEntityRepository testRepository;

	MyEntityController(MyEntityRepository testRepository) {
		this.testRepository = testRepository;
	}

	@GetMapping
	public List<MyEntity> getAllMyEntities() {
		return testRepository.findAll();
	}

	@PostMapping
	public MyEntity createMyEntity() {
		return testRepository.save(new MyEntity());
	}
}
