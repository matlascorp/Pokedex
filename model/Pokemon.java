package com.qa.pokedex.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {
	
	//object creation
	
	public Pokemon(String name, String type, Integer hP, boolean evolved) {
		super();
		this.name = name;
		this.type = type;
		HP = hP;
		this.evolved = evolved;
	}

	public Pokemon(long id, String name, String type, Integer hP, boolean evolved) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		HP = hP;
		this.evolved = evolved;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private Integer HP;
	
	@Column(nullable = false)
	private boolean evolved;
	
	

	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Generating constructor with ID to retrieve data
	public Pokemon(long id, String name, String type, Integer HP, Boolean evolved) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.HP = HP;
		this.evolved = evolved;
	}
	
	
	//Without ID so we can post data
	public Pokemon(String name, Integer HP, boolean evolved, String type) {
		super();
		this.name = name;
		this.type = type;
		this.HP = HP;
		this.evolved = evolved;
	}

	//Generating getters and setters

	public Pokemon(String string, String string2, int i, boolean b) {
		// TODO Auto-generated constructor stub
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return Objects.hash(HP, evolved, id, name, type);
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
				&& Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}



	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", type=" + type + ", HP=" + HP + ", evolved=" + evolved + "]";
	}


	}




