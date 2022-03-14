package com.harman.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.harman.demo.model.SuperHeroes;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/testing")
	public ResponseEntity<String> testMe() throws JsonMappingException, JsonProcessingException
	{
		String s="this is working";
		return ResponseEntity.ok(s);	
		}
	
	@RequestMapping("/character/{name}")
	public ResponseEntity<SuperHeroes> getTheCharacter(@PathVariable("name")String name) throws JsonMappingException, JsonProcessingException
	{
		String s="this is working";
	SuperHeroes hero=testService.getLatestData(name);
	if(hero!=null) {
		return ResponseEntity.ok(hero);	
		}else
		{
			return ResponseEntity.notFound().build();
		}

}

}
