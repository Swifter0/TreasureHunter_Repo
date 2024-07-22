package hm.Java_FE_Treasurehuntgame_Homework.dto;

public class UserDto {

	private int id;
	private String name;
	private int life;
	private Integer leastSteps;
	
	public UserDto(int id, String name, int life, Integer leastSteps) {
		super();
		this.id = id;
		this.name = name;
		this.life = life;
		this.leastSteps = leastSteps;
	}

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getLife() {
		return life;
	}


	public void setLife(int life) {
		this.life = life;
	}


	public Integer getLeastSteps() {
		return leastSteps;
	}


	public void setLeastSteps(Integer leastSteps) {
		this.leastSteps = leastSteps;
	}


	@Override
	public String toString() {
		return "UserDto [name=" + name + ", life=" + life + ", leastSteps=" + leastSteps + "]";
	}
	
}
