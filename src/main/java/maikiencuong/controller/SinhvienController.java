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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import maikiencuong.entity.Sinhvien;
import maikiencuong.repository.SinhvienRepo;

@RestController
@RequestMapping("/api/sinhviens")
public class SinhvienController {

	@Autowired
	private SinhvienRepo sinhvienRepo;

	@GetMapping
	public ResponseEntity<?> findAll(
			@RequestParam(value = "idLophoc", required = false, defaultValue = "0") int idLophoc) {
		if (idLophoc == 0)
			return ResponseEntity.ok(sinhvienRepo.findAll());
		else
			return ResponseEntity.ok(sinhvienRepo.findAllByLophoc_Id(idLophoc));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		Optional<Sinhvien> optional = sinhvienRepo.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok(optional.get());
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Sinhvien Sinhvien) {
		return ResponseEntity.ok(sinhvienRepo.save(Sinhvien));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		Optional<Sinhvien> findById = sinhvienRepo.findById(id);
		if (findById.isPresent()) {
			findById.get().setLophoc(null);
			sinhvienRepo.save(findById.get());
			sinhvienRepo.deleteById(id);
		}
	}

}
