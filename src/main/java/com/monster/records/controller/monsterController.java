package com.monster.records.controller;

import com.monster.records.exceptions.ResourceNotFoundException;
import com.monster.records.model.monster;
import com.monster.records.repository.monsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"https://kevinortiz43.github.io","localhost:3000", "localhost:4200"})
@RestController
@RequestMapping("/monster/")
public class monsterController {

	@Autowired 
	private monsterRepository monsterRepo;

	@GetMapping("/allmonsters")
	public List<monster> getAllMonsters() {
		return monsterRepo.findAll();
	}

	@PostMapping("/addmonsters")
	public monster newMonster(@RequestBody monster monster) {
		return monsterRepo.save(monster);
	}

	@GetMapping("/monster/{creature}")
	public List<monster> getCreature(@PathVariable String creature) {

		List<monster> monster = monsterRepo.findByCreature(creature);
		if (monster.isEmpty()) {
			System.out.println(new ResourceNotFoundException("monsters with the name + " + creature + "not found"));
		}
		return monsterRepo.findByCreature(creature);
	}

	@GetMapping("/monsterId/{id}")
	public ResponseEntity<monster> getMonsterById(@PathVariable int id) {
		monster monster = monsterRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
		return ResponseEntity.ok(monster);
	}

	@PutMapping("/monsterId/{id}")
	public ResponseEntity<monster> updatedMonsters(@PathVariable int id, @RequestBody monster monster) {
		monster monsterId = monsterRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("monster not found"));
		monsterId.setArmor(monster.getArmor());
		monsterId.setAlignment(monster.getAlignment());
		monsterId.setChallenge(monster.getChallenge());
		monsterId.setCreature(monster.getCreature());
		monsterId.setHealth(monster.getHealth());
		monsterId.setClassification(monster.getClassification());
		monsterId.setSize(monster.getSize());
		monsterId.setPortrait(monster.getPortrait());
		monsterId.setLegendary(monster.isLegendary());
		monster updatedMonsters = monsterRepo.save(monsterId);
		return ResponseEntity.ok(updatedMonsters);
	}

	@DeleteMapping("/monsterId/{id}")
	public String deleteMonsters(@PathVariable int id) {
		monsterRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Monster not found"));
		monsterRepo.deleteById(id);
		return "The Monster with id: " + id + " is removed from the database ";
	}

}
