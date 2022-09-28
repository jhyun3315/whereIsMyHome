package map.Service;

import java.util.List;

import map.dto.MapDto;

public interface MapService { 
	
	public List<MapDto> selectmap(String sidoName, String gugunName, String dongName) throws Exception;  
}
