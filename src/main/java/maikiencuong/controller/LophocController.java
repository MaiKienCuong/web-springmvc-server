package maikiencuong.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import maikiencuong.entity.Lophoc;
import maikiencuong.repository.LophocRepo;

@RestController
@RequestMapping("/api/lophocs")
public class LophocController {

	@Autowired
	private LophocRepo lophocRepo;

	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(lophocRepo.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		Optional<Lophoc> optional = lophocRepo.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok(optional.get());
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Lophoc lophoc) {
		return ResponseEntity.ok(lophocRepo.save(lophoc));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		lophocRepo.deleteById(id);
	}

}
