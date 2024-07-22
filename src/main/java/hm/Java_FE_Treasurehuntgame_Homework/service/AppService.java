package hm.Java_FE_Treasurehuntgame_Homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hm.Java_FE_Treasurehuntgame_Homework.database.Database;
import hm.Java_FE_Treasurehuntgame_Homework.dto.UserDto;
import hm.Java_FE_Treasurehuntgame_Homework.model.User;

@Service
public class AppService {

	private Database db;

	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}

	public UserDto checkRegisteredUser(String name, String password) {
		
		UserDto userDto = null;
		
		User user = db.getUserByNameAndPassword(name, password);
		
		if(user != null) {
			
			userDto = new UserDto(user.getId(), user.getName(), user.getLife(), user.getLeastSteps());
			
		}
		
		return userDto;
	}

	public UserDto saveGame(int userId, int win, int steps) {
		
		UserDto userDto = null;
		
		User user = db.getUserById(userId);
		
		if(user != null) {
			
			if(win == 1) {
				
				if(user.getLeastSteps() == null || user.getLeastSteps() > steps) {
					
					user.setLeastSteps(steps);
					db.mergeUser(user);
					
				}
				
			}
			else if(win == 2) {
				
				int userHealth = user.getLife();
				userHealth--;
				user.setLife(userHealth);
				db.mergeUser(user);
				
			}
			
			userDto = new UserDto(user.getId(), user.getName(), user.getLife(), user.getLeastSteps());
			
		}
		
		return userDto;
	}

	public UserDto getUserDtoById(int userId) {
		
		UserDto userDto = null;
		
		User user = db.getUserById(userId);
		
		if(user != null) {
			
			userDto = new UserDto(user.getId(), user.getName(), user.getLife(), user.getLeastSteps());
			
		}
		
		return userDto;
	}
	
	
	
	
	
}
