package map.dao;

import java.util.List;
import java.util.Map;

import map.dto.MapDto;

public interface MapDao { 
			
	public List<MapDto> selectmap(String sidoName, String gugunName, String dongName) throws Exception;   
	public List<String> sidoNamelist();
	public Map<String, String[]> select();
	 
}
