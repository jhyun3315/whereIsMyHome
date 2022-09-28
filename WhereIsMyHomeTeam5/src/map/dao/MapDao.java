package map.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import map.dto.MapDto;

public interface MapDao { 
			
	public List<MapDto> selectmap(String sidoName, String gugunName, String dongName) throws Exception;   
	public List<String> sidoNamelist();
	public HashMap<String, HashMap<String, ArrayList<String>>> sidogugunmap();
	 
}
