package com.capgemini.springTask1.hours;

import org.springframework.stereotype.Component;

@Component
public class HoursMapper {
	
public HoursDTO convert (HoursEntity entity){
	HoursDTO dto = new HoursDTO(entity.getPlayerId(), entity.getDay(), entity.getStart(), entity.getEnd());
		return dto;
}

public HoursEntity convert (HoursDTO dto){
	HoursEntity entity = new HoursEntity(dto.getPlayerId(), dto.getDay(), dto.getStart(), dto.getEnd());
	return entity;
}
}
