package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Position;
import com.revature.service.PositionServiceImpl;

@Controller("positionController")
@CrossOrigin(origins = "http://localhost:4200")
public class PositionControllerImpl {
	
	@Autowired
	public PositionServiceImpl positionService;
	
	@PostMapping("/setPosition")
	public @ResponseBody double setPosition(@RequestBody Position position, HttpServletRequest request) {
		
		positionService.createOrUpdatePosition(position);
		return position.getQuantity();
	}
}
