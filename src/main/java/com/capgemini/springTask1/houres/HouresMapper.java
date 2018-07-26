package com.capgemini.springTask1.houres;

import org.springframework.stereotype.Component;

@Component
public class HouresMapper {
	
public HouresDTO convert (HouresEntity entity){
	HouresDTO dto = new HouresDTO(entity.getPlayerId(), entity.getDay(), entity.getStart(), entity.getEnd());
		return dto;
}

public HouresEntity convert (HouresDTO dto){
	HouresEntity entity = new HouresEntity(dto.getPlayerId(), dto.getDay(), dto.getStart(), dto.getEnd());
	return entity;
}
}
