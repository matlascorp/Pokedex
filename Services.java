package com.qa.pokedex.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.qa.pokedex.model.Pokemon;
import com.qa.pokedex.repo.Repo;


//Annotation tells Spring this is our service class and contains the business logic for pushing data to database
@Service
public class Services {
	
	//Specify that we are using repo class
	
	private Repo repo;
	
	public Services(Repo repo) {
		super();
		this.repo = repo;
	}
	
	//Replaces SQL query
	public boolean createPokemonDB(Pokemon pokemon) {
		//This method takes in an entity and puts it into the DB
		repo.save(pokemon);
		return true;
	}

	private ArrayList<Pokemon> pokemonList = new ArrayList<>();
	
	public boolean createPokemon(Pokemon pokemon) {
		
		pokemon.setId(pokemonList.size() + 1);
		pokemonList.add(pokemon);
		return true;
	}
	
	public Pokemon getByIndex(int index) {
		// TODO Auto-generated method stub
		return pokemonList.get(index);
		
	}
	


	public ArrayList<Pokemon> getPokemon() {
		// TODO Auto-generated method stub
		return pokemonList;
	}

	public boolean remove(int index) {
		pokemonList.remove(index);
		return true;
	}

	public boolean clear() {
		pokemonList.clear();
		return true;
		// TODO Auto-generated method stub
		
	}

	public boolean set(int index, Pokemon pokemon) {
		pokemonList.set(index, pokemon);
		return true;
		// TODO Auto-generated method stub
		
	}

	public boolean update(int index, Pokemon pokemon) {
		pokemonList.set(index, pokemon);
		return true;
		
	}


	}
	
	
