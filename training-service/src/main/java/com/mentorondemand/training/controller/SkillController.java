package com.mentorondemand.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.training.dto.SkillDTO;
import com.mentorondemand.training.service.SkillService;

@RestController
@RequestMapping(value = "/api/admin/skill")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SkillDTO> getSkill(@PathVariable Integer id){
		SkillDTO skill = skillService.getSkill(id);
		return ResponseEntity.ok(skill);
	}
	

	@GetMapping(value = "/getSkills")
	public ResponseEntity<List<SkillDTO>> getSkills(){
		List<SkillDTO> skills = skillService.getSkills();
		return ResponseEntity.ok(skills);
	}
	
	@PostMapping
	public ResponseEntity<SkillDTO> createSkill(@RequestBody SkillDTO skillDTO){
		SkillDTO skill = skillService.createSkill(skillDTO);
		return ResponseEntity.ok(skill);
	}
	
	@PutMapping
	public ResponseEntity<SkillDTO> updateSkill(@RequestBody SkillDTO skillDTO){
		SkillDTO skill = skillService.updateSkill(skillDTO);
		return ResponseEntity.ok(skill);
	}
	
	
	

}
