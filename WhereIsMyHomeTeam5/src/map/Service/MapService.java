package map.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import map.dto.MapDto;

public interface MapService { 
	
	public List<MapDto> selectmap(String sidoName, String gugunName, String dongName) throws Exception;  
	public List<String> sidoNamelist();
	public HashMap<String, HashMap<String, ArrayList<String>>> sidogugunmap();
}
