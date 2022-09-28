package map.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import map.dto.MapDto;

public interface MapService { 
	public ArrayList<String> getsido();
	public ArrayList<String> getgugun(String sidoName);
	public ArrayList<String> getdong(String gugunName);
	
}
