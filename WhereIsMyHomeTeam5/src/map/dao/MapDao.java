package map.dao;

import java.util.List;
import map.dto.MapDto;

public interface MapDao {
	
	public List<MapDto> selectMember() throws Exception;  
	
	public MapDto selectMember(String aptNo) throws Exception;
	 
}
