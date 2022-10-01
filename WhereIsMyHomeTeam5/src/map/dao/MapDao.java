package map.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import map.dto.DealDto;
import map.dto.HomeDto;
import map.dto.MapDto;

public interface MapDao { 
			 
	public ArrayList<DealDto> gethomelist(String dongCode, String year, String month);
	
	
	 
}
