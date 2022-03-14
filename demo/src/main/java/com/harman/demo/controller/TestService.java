package com.harman.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.harman.demo.model.SuperHeroes;

import net.minidev.json.JSONObject;

@Service
public class TestService {
	
	private static final String avengers="http://www.mocky.io/v2/5ecfd5dc3200006200e3d64b";
	private static final String antiHeroes="http://www.mocky.io/v2/5ecfd630320000f1aee3d64d";
	private static final String mutants="http://www.mocky.io/v2/5ecfd6473200009dc1e3d64e";
	
	private  List<SuperHeroes> allList= new ArrayList<SuperHeroes>();
	
	public List<SuperHeroes> getData(String name) throws JsonMappingException, JsonProcessingException
	{
		Gson gson= new GsonBuilder().create();
		List<SuperHeroes> list=new ArrayList<SuperHeroes>();
		RestTemplate rest= new RestTemplate();
		String  obj= rest.getForObject(name, String.class);
		JsonObject json=JsonParser.parseString(obj).getAsJsonObject();
		JsonArray array= json.getAsJsonArray("character");
		for(int i=0;i<array.size();i++)
		{
			SuperHeroes hero= gson.fromJson(array.get(i).toString(),SuperHeroes.class);
			list.add(hero);    
		}
		return list;
		
	}
	public SuperHeroes getLatestData(String heroName) throws JsonMappingException, JsonProcessingException
	{
		allList= new ArrayList<>();
		allList.addAll(getData(avengers));
		allList.addAll(getData(mutants));
		 Collections.sort(allList);
		 List<SuperHeroes> firstN = 
				 allList.stream().limit(15).collect(Collectors.toList());
		allList= firstN;
		System.out.println(allList);
		Optional<SuperHeroes> matchingObject = allList.stream().
			    filter(p -> p.getName().trim().equalsIgnoreCase(heroName.trim())).
			    findFirst();
		return matchingObject.orElse(null);
	}

}
