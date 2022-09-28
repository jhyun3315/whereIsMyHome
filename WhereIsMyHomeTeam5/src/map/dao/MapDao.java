package map.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import map.dto.MapDto;

public interface MapDao { 
			
	public ArrayList<String> getsido();
	public ArrayList<String> getgugun(String sidoName);
	public ArrayList<String> getdong(String gugunName);
	
	
	 
}
