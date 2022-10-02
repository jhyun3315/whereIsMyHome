package map.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

import map.dto.DealDto;
import map.dto.HomeDto;

public interface MapService {  
	public ArrayList<DealDto> gethomelist(String dongCode, String year, String month); 
	public ArrayList<HomeDto> getdeallist(String aptCode, String aptName);
}
