package com.capgemini.springTask1.houres;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springTask1.system.Login;

@Service
public class HouresService {

	private final HouresDAO houresDAO;
	private final HouresMapper houresMapper;
	int loggedUserId = Login.getLoginId();

	@Autowired
	public HouresService(HouresDAO houresDAO, HouresMapper houresMapper) {
		this.houresDAO = houresDAO;
		this.houresMapper = houresMapper;

	}

	//all houres of all players ---- to change for one USERID
	public List<HouresDTO> getHoures() {
		List<HouresEntity> houres = houresDAO.getHoures();
		List<HouresDTO> newHoures = new ArrayList<HouresDTO>();
		for (int i = 0; i < houres.size(); i++) {
			HouresDTO houresDTO = houresMapper.convert((HouresEntity) houres.get(i));
			newHoures.add(houresDTO);
		}
		return newHoures;
	}
	
//	public List getUserHoures(){
//		List allHoures = this.getHoures();
//		List userHoures = null;
//		for (int i=0; i < allHoures.size(); i++){
//			HouresDTO time = (HouresDTO) allHoures.get(i);
//			if (time.getPlayerId()==loggedUserId;)
//			userHoures.set(i, allHoures.get(i))
//		}
//	}
	
	
	public void changeHoures(List <HouresDTO> houresDTO){
		List<HouresEntity> houresEntities = new ArrayList<>();
		for (int i=0; i < houresDTO.size(); i++){
			HouresEntity houresEntity = houresMapper.convert(houresDTO.get(i));
		}
		houresDAO.saveHoures(houresEntities);
	}
	
	public void deleteHoures(HouresDTO houresDTO){
		HouresEntity houresEntity = houresMapper.convert(houresDTO);
		houresDAO.deleteHoures(houresEntity);
	}
	
//	public void createChallangeList{
//		List allHoures = this.getHoures();
//		List userHoures
//		for (int i =0; i<)
//	}

}
