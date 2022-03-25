package com.qa.pokedex.services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.pokedex.model.Pokemon;
import com.qa.pokedex.repo.Repo;

@Service
public class Services {
	
	private Repo repo;

	public Services(Repo repo) {
		super();
		this.repo = repo;
	}
	
	public boolean createPokemon(Pokemon pokemon) {
		//This method takes in an entity and puts it into the DB
		repo.save(pokemon);
		return true;
		
	}

	public List<Pokemon> getPokemon() {
		
		return repo.findAll();
	}

	public Pokemon getById(long id) {
		
		
		return repo.findById(id).get();
	}

	
	public boolean deleteAll() {
		repo.deleteAll();
		return true;
		
	}

	public boolean remove(long id) {
		repo.deleteById(id);
		return true;
	}
	
	//Needs to be able to take in ID and request body
	public boolean update(long id, Pokemon pokemon) {
		Pokemon oldPokemon = getById (id);
		oldPokemon.setName(pokemon.getName());
		oldPokemon.setType(pokemon.getType());
		oldPokemon.setHP(pokemon.getHP());
		oldPokemon.setEvolved(pokemon.isEvolved());
		Pokemon updatedPokemon = oldPokemon;
		repo.save(updatedPokemon);
		return true;
	
		
	}
	
	
	public List<Pokemon> getByName(String name){
		
		return repo.findByName(name);
	}
	
	public List<Pokemon> getByType(String type){
		
		return repo.findByType(type);
	}

//	public List<Pokemon> getbyhPGreater(int hP) {
//		
//		return repo.findbyhPGreaterThan(hP);
//	}	
		
	
//	public List<Pokemon> getbyAllOrderByHP(){
//		
//		return repo.findByOrderByHpAsc();
//		
//	}
//		
//	public List<Pokemon> getAllOrderByHP() {
//		
//		return repo.findByOrderByHpDesc();
	



}
	

		
	
