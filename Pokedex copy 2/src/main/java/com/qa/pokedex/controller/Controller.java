package com.qa.pokedex.controller;

import java.util.List;
import java.util.concurrent.ExecutorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.pokedex.model.Pokemon;
import com.qa.pokedex.services.Services;

//This class is a controller class for taking HTTP requests
@RestController
public class Controller {
	
	
	
	private Services service;
	
	public Controller(Services service) {
		super();
		this.service = service;
	}


	//Method for adding to database
	@PostMapping("/createPokemon")
	public ResponseEntity<String> createPokemon(@RequestBody Pokemon pokemon) {
		
		
		service.createPokemon(pokemon);
		
		ResponseEntity<String> response = new ResponseEntity<> ("Pokemon added with id: " + pokemon.getId(), HttpStatus.CREATED);
		
		return response;
		
	}
	
	
	//Method for /getPokemon and returns pokemonList with reponse entity
	@GetMapping("/getPokemon")
	public ResponseEntity<List<Pokemon>> getPokemon(){
		
		List<Pokemon> response = service.getPokemon();
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		
	}

		
	//Method for calling id and calling variables
	@GetMapping("/get/{id}")
	public ResponseEntity<Pokemon> getById(@PathVariable long id) {
		
		//Making an object variable called result which equals the data we are retrieving 
		Pokemon result = service.getById(id);
		
		//Making a ResponseEntity that contains the date we are sending 
		ResponseEntity<Pokemon> response = new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		
		return response;
		
		
	}
	
	//Listens for number and deletes the corresponding object
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteByid (@PathVariable("id") long id ) {
		service.remove(id );
		
		String response = "Pokemon of id: " + id  + "deleted";
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		
	}
	
	//To delete all 
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		service.deleteAll();
		return "Deleted";
	}
	
	//Update by id 
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateByid (@PathVariable("id") long id, @RequestBody Pokemon pokemon) {
		service.update(id, pokemon);
		String response = "Updating pokemon of id " + id;
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/gettype/{type}")
	public ResponseEntity <List<Pokemon>> getbyType(@PathVariable("type") String type) {
		
		List<Pokemon> response = service.getByType(type);
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getname/{name}")
	public ResponseEntity <List<Pokemon>> getbyName(@PathVariable("name") String name) {
		
		List<Pokemon> response = service.getByName(name);
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
//	@RequestMapping("/pokemon")
//	class Pokemon {
//
//	    private Name name;
//	    private Hp hp;
//	    private Mapper mapper;
//
//	    // Constructor
//
//	    @GetMapping
//	    @ResponseBody
//	    public List<Pokemon> getPokemon() {
//	        return ExecutorService.getAll()
//	          .stream()
//	          .map(mapper::toDto)
//	          .collect();
//	    }
//
//
//	    @PostMapping
//	    @ResponseBody
//	    public pokemon create(@RequestBody) {
//	        Pokemon pokemon = mapper.toUser(pokemonDTO);
//
//	        userDTO.getRoles()
//	          .stream()
//	          .map(hp -> hp.getOrCreate(hp))
//	          .forEach(user::addRole);
//
//	  
//
//	        return new hpIdDTO(pokemon.getId());
//	    }
//
//	}
	
}
