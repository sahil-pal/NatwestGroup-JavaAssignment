package com.natwest.app.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.natwest.app.AppConstants;

@Service
public class GameService {
	
	private Logger logger;
	
	@Autowired
	private Random random;
	
	GameService(){
		logger = LoggerFactory.getLogger(GameService.class);
	}

	public int computeResult(String userInput){
		String computerInput = generateComputerMove();
		logger.trace("computer action : "+computerInput);
		return findTheWinner(userInput, computerInput);
	}
	
	public String generateComputerMove() {
		int randomValue = random.nextInt(9)+1;
		if(randomValue > 0 && randomValue < 4) {
			return AppConstants.STONE;
		}
		else if(randomValue > 3 && randomValue < 7) {
			return AppConstants.PAPER;
		}
		else {
			return AppConstants.SCISSOR;
		}
	}
	
	public int findTheWinner(String uInput,String cInput) {
		if(uInput.equals(cInput)) {
			return AppConstants.TIE_STATUS_CODE;
		}
		else if(uInput.equals(AppConstants.PAPER) && cInput.equals(AppConstants.SCISSOR)
				|| uInput.equals(AppConstants.SCISSOR) && cInput.equals(AppConstants.STONE)
				|| uInput.equals(AppConstants.STONE) && cInput.equals(AppConstants.PAPER)
				) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	
}
