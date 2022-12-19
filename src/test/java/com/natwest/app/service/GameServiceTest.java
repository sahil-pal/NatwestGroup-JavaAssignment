package com.natwest.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameServiceTest {
	
	@Autowired
	private Random random;
	
	@Autowired
	private GameService gameService;

	@Test
	public void generateComputerMove() {
		int randomValue = random.nextInt(9)+1;
		boolean result = ( randomValue > 0 && randomValue < 10 );
		assertEquals(true, result);
	}
	
	@Test 
	public void findTheWinner() {
		String user = "scissor";
		String cpu = "paper";	
		int result = gameService.findTheWinner(user, cpu);
		assertEquals(1,result);
	}
	
}
