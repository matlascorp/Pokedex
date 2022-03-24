//package com.qa.pokedex.testing;
//
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.qa.pokedex.model.Pokemon;
//import com.qa.pokedex.repo.Repo;
//import com.qa.pokedex.services.Services;
//
//@SpringBootTest
//
//public class ServiceTest {
//	
//	@MockBean
//	private Repo repo;
//	
//	@Autowired
//	private Services service;
//	Pokemon pokemon1 = new Pokemon(0, "name1", "type1", 1, true);
//	Pokemon pokemon2 = new Pokemon(0, "name2", "type2", 2, false);
//	
//	Pokemon pokemon1Id = new Pokemon(1l, "name1", "type1", 1, true);
//	Pokemon pokemon2Id = new Pokemon(2l, "name", "type2", 2, false);
//	
//	@Test
//	public void testCreate() {
//		Mockito.when(repo.save(pokemon1)).thenReturn(pokemon1);
//		
//		Pokemon result = service.createPokemon(pokemon1);
//		
//		Assertions.assertEquals(pokemon1, result);
//			
//	}
//	
//	
//
//}
