package com.harman.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuperHeroes implements Comparable{
	
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("max_power")
	private int max_power;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "SuperHeroes [name=" + name + ", max_power=" + max_power + "]";
	}
	public int getMax_power() {
		return max_power;
	}
	public void setMax_power(int max_power) {
		this.max_power = max_power;
	}
	@Override
	public int compareTo(Object o) {
		return this.getMax_power()-((SuperHeroes)o).getMax_power();
	}
	
	

}
