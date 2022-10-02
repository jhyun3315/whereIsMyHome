package map.dao;

import java.util.ArrayList; 

import map.dto.DealDto;
import map.dto.HomeDto;

public interface MapDao { 
			 
	public ArrayList<DealDto> gethomelist(String dongCode, String year, String month);
	public ArrayList<HomeDto> getdeallist(String aptCode, String atpName);
	
	 
}
