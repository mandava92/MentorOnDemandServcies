package com.mentorondemand.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.admin.dto.SkillDTO;
import com.mentorondemand.admin.service.SkillService;

@RestController
@RequestMapping(value = "/api/skill")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SkillDTO> getSkill(@PathVariable Integer id){
		skillService.getSkill(id);
		return null;
	}
	

	@GetMapping(value = "/getSkills")
	public ResponseEntity<SkillDTO> getSkills(){
		skillService.getSkills();
		return null;
	}
	

}
