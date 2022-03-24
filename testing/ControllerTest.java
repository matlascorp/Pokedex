package com.qa.pokedex.testing;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pokedex.model.Pokemon;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ControllerTest {
	
	
	//Plugsin MockMVC directly into Spring App
	@Autowired
	private MockMvc mvc;
	
	
	//Converts Java Obect to JSON strings
	@Autowired
	private ObjectMapper mapper;
	
	//Test Object
	Pokemon testCreatePokemon = new Pokemon();
	Pokemon testGetPokemonId = new Pokemon();
	Pokemon testDeletePokemon = new Pokemon();
	
	@Test
	public void testCreate() throws JsonProcessingException {
		
		//Arranging and converting our Test Object into a JSON string called pokemonJSON
		String pokemonJson = mapper.writeValueAsString(testCreatePokemon);
		
		
		//Importing requestbuilder, posting Json string and content, also identifying request type and path
		//Equivalent to writing postman requests before sending
		RequestBuilder req = post("/createPokemon").contentType(MediaType.APPLICATION_JSON).content(pokemonJson);
		
		
		//Actioning by making a resultmatcher object as a boolean depending on status created
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().string("Booking added with ID: 4");
		
	}
		
		
		@Test
		public void testgetPokemon() throws Exception {
			
		//Arranging and converting our Test Object into a JSON string called pokemonJSON
			
		List<Pokemon> allPokemon = List.of();
		
	
		String allPokemonJson = mapper.writeValueAsString(allPokemon);
			
			
			//Importing requestbuilder, posting Json string and content, also identifying request type and path
			//Equivalent to writing postman requests before sending
			RequestBuilder req = get("/getPokemon");
			
			
			//Actioning by making a resultmatcher object as a boolean depending on status created
			ResultMatcher checkStatus = status().isAccepted();
			ResultMatcher checkBody = content().string(allPokemonJson);
			
			mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		

	}
		@Test
		public void testGetId() throws Exception {
			
			Object testPokemonId = null;
			String testPokemonIdJson = mapper.writeValueAsString(testPokemonId);
			//Importing requestbuilder, posting Json string and content, also identifying request type and path
			//Equivalent to writing postman requests before sending
			RequestBuilder req = get("/get/id");
			
			
			//Actioning by making a resultmatcher object as a boolean depending on status created
			ResultMatcher checkStatus = status().isAccepted();
			ResultMatcher checkBody = content().json(testPokemonIdJson);
		
		}
		
//		@Test
//		public void testDeleteId() throws Exception {
//			
//			
//			//Importing requestbuilder, posting Json string and content, also identifying request type and path
//			//Equivalent to writing postman requests before sending
//			RequestBuilder req = delete("/delete/ID");
//			
//			
//			//Actioning by making a resultmatcher object as a boolean depending on status created
//			ResultMatcher checkStatus = status().isAccepted();
//			ResultMatcher checkBody = content().string("Pokemon of id: deleted");
//			mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
//	}
//		
//		@Test
//		public void testUpdate() throws Exception {
//			
//			Pokemon updatedPokemon = new Pokemon();
//			
//			String updatedPokemonJson = mapper.writeValueAsString(updatedPokemon);
//			
//			//Importing requestbuilder, posting Json string and content, also identifying request type and path
//			//Equivalent to writing postman requests before sending
//			RequestBuilder req = put("/update/ID").contentType(MediaType.APPLICATION_JSON).content(updatedPokemonJson);
//			
//			
//			//Actioning by making a resultmatcher object as a boolean depending on status created
//			ResultMatcher checkStatus = status().isAccepted();
//			ResultMatcher checkBody = content().string("Updating pokemon of id:");
//			mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
//	}
}
