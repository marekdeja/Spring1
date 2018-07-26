package com.capgemini.springTask1.hours;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.capgemini.springTask1.system.Login;

import database.DatabaseHours;

@Repository
public class HoursDAO {
	DatabaseHours databaseHours = new DatabaseHours();
	List<HoursEntity> hours = databaseHours.getHours();

	int loggedUserId = Login.getLoginId();

	public List<HoursEntity> findhours() {
		return hours;
	}

	/**
	 * @author MADEJA every previous available time is deleted, then new
	 *         available time is added to Array
	 *
	 */
	public void savehours(List<HoursEntity> hoursEntities) {

		hours.stream().forEach(s -> {
			if (s.getPlayerId() == loggedUserId) {
				hours.remove(s);
			}
		});

		hoursEntities.stream().forEach(s -> hours.add(s));
	}

	public void deletehours(HoursEntity hoursEntity) {
		// TODO Auto-generated method stub
		hours.remove(hoursEntity);
	}

}