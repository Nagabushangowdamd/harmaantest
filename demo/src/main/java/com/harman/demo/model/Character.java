package com.harman.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Character {
	@JsonProperty("name")
	private String name;
	@JsonProperty("character")
	private List<SuperHeroes> character;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SuperHeroes> getCharacter() {
		return character;
	}
	public void setCharacter(List<SuperHeroes> character) {
		this.character = character;
	}
	

}
