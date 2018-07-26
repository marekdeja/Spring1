package database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.springTask1.gamesHistory.GameEntity;
import com.capgemini.springTask1.houres.HouresEntity;

public class DatabaseHoures {
	
	private List houres;
	
	public DatabaseHoures(){
		houres = new ArrayList();
		houres.add(new HouresEntity(0, "Monday", 5, 9));
		houres.add(new HouresEntity(1, "Monday", 6, 17));
	}
	
	public List getHoures(){
		return houres;
	}

}
