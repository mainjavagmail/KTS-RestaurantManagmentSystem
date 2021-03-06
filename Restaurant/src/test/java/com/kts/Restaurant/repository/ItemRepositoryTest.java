package com.kts.Restaurant.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kts.Restaurant.model.Item;

@ExtendWith(SpringExtension.class)
@DataNeo4jTest
@TestPropertySource("classpath:application-test.properties")
public class ItemRepositoryTest {
	
	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	DBTestRepository dbTestRepo;
	
	@BeforeEach
	public void setup() {
		
		
	
		dbTestRepo.deleteEveryNodeAndRel();
		dbTestRepo.createDBData();
	}
	
	@Test
	public void findAllTest() {
		List<Item> items = itemRepo.findAll();
		
		assertTrue(items.size() == 2);
	}

}
