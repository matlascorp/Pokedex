package com.qa.pokedex.controller;

import java.util.ArrayList;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.pokedex.model.Pokemon;

//This class is a controller class for taking HTTP requests
@RestController
public class Controller {
	
	
	private ArrayList<Pokemon> pokemonList = new ArrayList<>();
	
	
	//Method for /getPokemon and returns pokemonList
	@GetMapping("/getPokemon")
	public ArrayList<Pokemon> getPokemon(){
		System.out.println(pokemonList);
		return pokemonList;
		
	}


	//Method for adding to database
		@PostMapping("/createNewPokemon")
		public boolean createNewPokemon(@RequestBody Pokemon pokemon) {
			return pokemonList.add(pokemon);
			
			
		}
		
	//Method for calling indexing and calling variables
	@GetMapping("/get/{index}")
	public Pokemon getByIndex(@PathVariable("index") int index) {
		return pokemonList.get(index);
		
		
	}
	
	//Listens for number and deletes the corresponding object
	@DeleteMapping("/delete/{index}")
	public Pokemon deleteByIndex(@PathVariable("index") int index) {
		return pokemonList.remove(index);
		
	}
	
	@DeleteMapping("/deleteAll")
	public boolean deleteAll() {
		pokemonList.clear();
		return true;
	}
	
	@PutMapping("/update/{index}")
	public boolean update(@PathVariable("index") int index, @RequestBody Pokemon pokemon) {
		pokemonList.set(index, pokemon);
		System.out.println("Object of index" + index + "updated.");
		return true;
	}
	
}
