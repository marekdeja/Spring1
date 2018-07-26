package com.capgemini.springTask1.hours;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springTask1.system.Login;

/**
 * @author MADEJA
 *
 */
/**
 * @author MADEJA
 *
 */
@Service
public class HoursService {
//user story 4
	private final HoursDAO hoursDAO;
	private final HoursMapper hoursMapper;
	int loggedUserId = Login.getLoginId();

	@Autowired
	public HoursService(HoursDAO hoursDAO, HoursMapper hoursMapper) {
		this.hoursDAO = hoursDAO;
		this.hoursMapper = hoursMapper;

	}

	//all hours of all players
	public List<HoursDTO> getHours() {
		List<HoursEntity> hours = hoursDAO.findhours();
		List<HoursDTO> newhours = new ArrayList<HoursDTO>();
		for (int i = 0; i < hours.size(); i++) {
			HoursDTO hoursDTO = hoursMapper.convert((HoursEntity) hours.get(i));
			newhours.add(hoursDTO);
		}
		return newhours;
	}
	
	//hour availability
	public List getUserhours(){
		List <HoursDTO> allhours = this.getHours();
		List <HoursDTO> userhours = new ArrayList<>();;
		for (int i=0; i < allhours.size(); i++){
			HoursDTO time = (HoursDTO) allhours.get(i);
			if (time.getPlayerId()==loggedUserId){
				userhours.add(time);
			}
		}
		return userhours;
	}
	
	
	public void changehours(List <HoursDTO> hoursDTO){
		List<HoursEntity> hoursEntitiesUser = new ArrayList<>();
		for (int i=0; i < hoursDTO.size(); i++){
			HoursEntity hoursEntity = hoursMapper.convert(hoursDTO.get(i));
		}
		hoursDAO.savehours(hoursEntitiesUser);
	}
	
	public void deletehours(HoursDTO hoursDTO){
		HoursEntity hoursEntity = hoursMapper.convert(hoursDTO);
		hoursDAO.deletehours(hoursEntity);
	}
	
	
	public List <HoursDTO> createChallangeList(){
		
		List restHours = this.getHours();
		List userHours = this.getUserhours();
		
		restHours.stream().forEach(s -> {
			if (((HoursDTO) s).getPlayerId() == loggedUserId) {
				restHours.remove(s);
			}
		});
		
		/*I check if user and enemy have the same day in available hours,
		 * then I check if their hours are in range (countRange)
		 * 
		 * @return
		 * array with possible players to have a challange with
		 */
	List <HoursDTO> similarHours = new ArrayList();
		
		for (int i=0; i<restHours.size();i++){
			for(int j=0; j<userHours.size(); j++){
				HoursDTO currentEnemyHours = (HoursDTO) restHours.get(i);
				HoursDTO currentUserHours = (HoursDTO) userHours.get(i);
				if((currentEnemyHours.getDay().equals(currentUserHours.getDay()))){
					if (this.countRange(currentUserHours.getStart(), currentUserHours.getEnd(), currentEnemyHours.getStart(), currentEnemyHours.getEnd())){
						similarHours.add(currentEnemyHours);
					}
				}
			}
			
		}
		return similarHours;
		
	}
	
	public boolean countRange(int hourStartUser, int hourEndUser, int hourStartEnemy, int hourEndEnemy){
		List userHours = new ArrayList();
		List enemyHours = new ArrayList();
		
		for (int i=hourStartUser+1; i<hourEndUser;i++){
			userHours.add(i, i);
		}
		for (int i=hourStartEnemy+1; i<hourEndEnemy;i++){
			enemyHours.add(i, i);
		}
		for (int i=0; i<userHours.size();i++){
			for (int j=0; j<enemyHours.size();i++){
				if (userHours.get(i)==enemyHours.get(j)){
					return true;
				}
			}
		}
		return false;
	}
}
