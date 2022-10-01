package map.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

import map.dto.DealDto;
import map.dto.MapDto;

public interface MapService {  
	public ArrayList<DealDto> gethomelist(String dongCode, String year, String month);
}
