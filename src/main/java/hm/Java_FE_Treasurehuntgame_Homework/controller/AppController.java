package hm.Java_FE_Treasurehuntgame_Homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hm.Java_FE_Treasurehuntgame_Homework.dto.FeedBackDto;
import hm.Java_FE_Treasurehuntgame_Homework.dto.UserDto;
import hm.Java_FE_Treasurehuntgame_Homework.service.AppService;

@Controller
public class AppController {
	
	private AppService service;

	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/user/loadlogin") 
	public String loadLogin() {
		
		return "login.html";
	}
	
	@PostMapping("/user/login")
	public String loginUser(
			Model model,
			@RequestParam("name") String name,
			@RequestParam("password") String password
			) {
		
		String targetPage = "login.html";
		
		UserDto userDto = service.checkRegisteredUser(name, password);
		
		if(userDto != null) {
			
			model.addAttribute("userdto", userDto);
			targetPage = "game.html";
			
		}
		else {
			
			FeedBackDto feedBackDto = new FeedBackDto("User Not Found! Try again!");
			model.addAttribute("feedbackdto", feedBackDto);
			
		}
		
		return targetPage;
	}
	
	
	@GetMapping("/user/game") 
	public String saveWinner(
			Model model,
			@RequestParam("userid") int userId,
			@RequestParam("win") int win,
			@RequestParam("steps") int steps
			) {
		
		String targetPage = "";
		
		UserDto userDto = service.saveGame(userId, win, steps);
		
		if(userDto.getLife() <= 0) {
			
			targetPage = "lost.html";
			
		}
		else {
			
			model.addAttribute("userdto", userDto);
			model.addAttribute("win", win);
			targetPage = "win.html";
			
		}
		
		
		return targetPage;
	}
	
	@GetMapping("/user/restart")
	public String restart(
			Model model,
			@RequestParam("restart") int restart,
			@RequestParam("userId") int userId
			) {
		
		String targetPage = "";
		
		if(restart == 1) {
			
			UserDto userDto = service.getUserDtoById(userId);
			
			if(userDto != null) {
				
				model.addAttribute("userdto", userDto);
				targetPage = "game.html";
				
			}
			
			
		}
		else {
			
			FeedBackDto feedBackDto = new FeedBackDto("Thanks for playing see you next time!");
			model.addAttribute("feedbackdto", feedBackDto);
			targetPage = "login.html";
			
		}
		
		return targetPage;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
