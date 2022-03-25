package com.qa.pokedex.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.pokedex.model.Pokemon;

//Repo class is for storing methods we need to access database
//repo.findAll() - returns data
//repo. save(Object) - Create an object and save it into DB

//JpaRepository takes in our object type and entity
public interface Repo extends JpaRepository<Pokemon, Long> {

	public List<Pokemon> findByName(String name);

	public List<Pokemon> findByType(String type);

	
}
