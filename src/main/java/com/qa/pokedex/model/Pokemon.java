package com.qa.pokedex.model;

import java.util.Objects;

public class Pokemon {
	
	//object creation
	
	private long id;
	
	private String name;
	
	private Integer HP;
	
	private boolean evolved;
	
	

	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	// Generating constructor with ID to retrieve data
	public Pokemon(long id, String name, Integer HP, Boolean evolved) {
		super();
		this.id = id;
		this.name = name;
		this.HP = HP;
		this.evolved = evolved;
	}
	
	
	//Without ID so we can post data
	public Pokemon(String name, Integer HP, boolean evolved) {
		super();
		this.name = name;
		this.HP = HP;
		this.evolved = evolved;
	}

	//Generating getters and setters

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getHP() {
		return HP;
	}



	public void setHP(Integer hP) {
		HP = hP;
	}



	public boolean isEvolved() {
		return evolved;
	}



	public void setEvolved(boolean evolved) {
		this.evolved = evolved;
	}



	@Override
	public int hashCode() {
		return Objects.hash(HP, evolved, id, name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(HP, other.HP) && evolved == other.evolved && id == other.id
				&& Objects.equals(name, other.name);
	}



	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", HP=" + HP + ", evolved=" + evolved + "]";
	}


	}




