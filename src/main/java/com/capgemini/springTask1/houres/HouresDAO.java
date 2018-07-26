package com.capgemini.springTask1.houres;

import java.util.List;

import org.springframework.stereotype.Repository;

import database.DatabaseHoures;

@Repository
public class HouresDAO {
DatabaseHoures databaseHoures = new DatabaseHoures();
List<HouresEntity> houres = databaseHoures.getHoures();

	public List<HouresEntity> getHoures(){
		return houres;
	}

	public void saveHoures(List<HouresEntity> houresEntities) {
		for (int i=0; i<houres.size(); i++){
			
			HouresEntity houresEntity = (HouresEntity) houresEntities.get(i);
			HouresEntity newHouresEntity = (HouresEntity) houres.get(i);
			
			newHouresEntity.setPlayerId(houresEntity.getPlayerId());
			newHouresEntity.setDay(houresEntity.getDay());
			newHouresEntity.setStart(houresEntity.getStart());
			newHouresEntity.setEnd(houresEntity.getEnd());
		}
	}

	public void deleteHoures(HouresEntity houresEntity) {
		// TODO Auto-generated method stub
		houres.remove(houresEntity);
	}
	
}