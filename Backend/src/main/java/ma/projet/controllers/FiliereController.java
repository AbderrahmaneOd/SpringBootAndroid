package ma.projet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.entities.Filiere;
import ma.projet.services.FiliereService;

@RestController
@RequestMapping("/api/filiere")
//@RequiredArgsConstructor
public class FiliereController {
	
	@Autowired
	private FiliereService filiereService;
	

	@GetMapping
	public List<Filiere> findAllFiliere(){
		return filiereService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Filiere filiere = filiereService.findById(id);
		if(filiere == null) {
			return new ResponseEntity<Object>("Filiere with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(filiere);
		}
	}
	
	@PostMapping
	public Filiere createFiliere(@RequestBody Filiere filiere) {
		filiere.setId(0);
		return filiereService.create(filiere);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateFiliere(@PathVariable int id,@RequestBody Filiere filiere) {
//		Filiere filiere = filiereService.findById(id);
		if(filiereService.findById(id) == null) {
			return new ResponseEntity<Object>("Filiere with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			filiere.setId(id);
			return ResponseEntity.ok(filiereService.update(filiere));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteFiliere(@PathVariable int id){
		Filiere filiere = filiereService.findById(id);
		if(filiere == null) {
			return new ResponseEntity<Object>("Filiere with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			filiereService.delete(filiere);
			return ResponseEntity.ok("Filiere has been deleted");
		}
	}
}
