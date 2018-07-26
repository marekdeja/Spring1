package database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.springTask1.gamesHistory.GameEntity;
import com.capgemini.springTask1.hours.HoursEntity;

public class DatabaseHours {
	
	private List<HoursEntity> hours;
	
	public DatabaseHours(){
		hours = new ArrayList<HoursEntity>();
		hours.add(new HoursEntity(0, "Monday", 5, 9));
		hours.add(new HoursEntity(1, "Monday", 6, 17));
	}
	
	public List<HoursEntity> getHours(){
		return hours;
	}

}
