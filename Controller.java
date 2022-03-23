package com.qa.pokedex.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.pokedex.model.Pokemon;
import com.qa.pokedex.services.Services;

//This class is a controller class for taking HTTP requests
@RestController
public class Controller {
	
	
	//private ArrayList<Pokemon> pokemonList = new ArrayList<>();
	
	//Telling controller to use service call and passes it into the Service Object
	private Services service;
	
	public Controller(Services service) {
		super();
		this.service = service;
	}


	//Method for adding to database
	@PostMapping("/createPokemon")
	public ResponseEntity<String> createPokemon(@RequestBody Pokemon pokemon) {
		System.out.println(pokemon);
		
		service.createPokemonDB(pokemon);
		
		ResponseEntity<String> response = new ResponseEntity<> ("Pokemon added with ID: " + pokemon.getId(), HttpStatus.CREATED);
		return response;
		
	}
	
	
	//Method for /getPokemon and returns pokemonList with reponse entity
	@GetMapping("/getPokemon")
	public ResponseEntity<ArrayList<Pokemon>> getPokemon(){
		
		ArrayList<Pokemon> response = service.getPokemon();
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		
	}

		
	//Method for calling indexing and calling variables
	@GetMapping("/get/{index}")
	public ResponseEntity<Pokemon> getByIndex(@PathVariable("index") int index) {
		
		//Making an object variable called result which equals the data we are retrieving 
		Pokemon result = service.getByIndex(index);
		
		//Making a ResponseEntity that contains the date we are sending 
		ResponseEntity<Pokemon> response = new ResponseEntity<>(result, HttpStatus.OK);
		
		return response;
		
		
	}
	
	//Listens for number and deletes the corresponding object
	@DeleteMapping("/delete/{index}")
	public ResponseEntity<String> deleteByIndex(@PathVariable("index") int index) {
		service.remove(index);
		
		String response = "Pokemon of index:" + index + "deleted";
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		
	}
	
	//To delete all 
	@DeleteMapping("/deleteAll")
	public boolean deleteAll() {
		service.clear();
		return true;
	}
	
	//Update by index
	@PutMapping("/update/{index}")
	public ResponseEntity<String> updateBtIndex(@PathVariable("index") int index, @RequestBody Pokemon pokemon) {
		service.update(index, pokemon);
		String response = "Object of index" + index;
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//Takes in query and value, as well as the request body we want to update it with
	@PutMapping("/update/{query}/{value}")
	public void updateAllObjects(@PathVariable("query") String query, @PathVariable("Value") String value, @RequestBody Pokemon pokemon) {
		
		}
		
	}

