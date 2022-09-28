package map.dao;

import java.util.List;

import map.dto.MapDto;

public interface MapDao { 
			
	public List<MapDto> selectmap(String sidoName, String gugunName, String dongName) throws Exception;  

	 
}
