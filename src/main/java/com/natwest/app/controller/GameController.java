package com.natwest.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.app.AppConstants;
import com.natwest.app.exceptions.NoInputFound;
import com.natwest.app.service.GameService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class GameController {

	@Autowired
	private GameService gameService;
	
	private Logger logger;
	
	GameController(){
		logger = LoggerFactory.getLogger(GameController.class);
	}
	
	@GetMapping("/action/{input}")
	@ApiOperation(
				value="Play RPS game",
				notes="Provide input as scissor/rock/paper as path variable"
			)
	public ResponseEntity<String> play(@PathVariable("input") String input){
		if(!input.equals(AppConstants.PAPER)
				&& !input.equals(AppConstants.SCISSOR)
				&& !input.equals(AppConstants.STONE)
				) {
			throw new NoInputFound("Please provide a proper Input");
		}
		else {
			logger.trace("user action : "+input);
			int result = gameService.computeResult(input);
			if(result == 0) {
				logger.info("It is a Tie");
				return ResponseEntity.ok().body("Game Tied");
			}
			else if(result == 1) {
				logger.info("User Won");
				return ResponseEntity.ok().body("User Won");
			}
			else {
				logger.info("CPU Won");
				return ResponseEntity.ok().body("CPU Won");
			}
		}
		
	}
	
}
