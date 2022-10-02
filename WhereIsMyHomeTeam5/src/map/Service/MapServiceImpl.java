package map.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import map.dao.MapDao;
import map.dao.MapDaoImpl;
import map.dto.DealDto;
import map.dto.HomeDto;

public class MapServiceImpl implements MapService{
	private static MapService mapservice = new MapServiceImpl();
	private MapDao dao;
	
	public MapServiceImpl() {
		dao = MapDaoImpl.getMapDao(); 
	} 
	
	public static MapService getMapService() {
		return mapservice;
	}

	@Override
	public ArrayList<DealDto> gethomelist(String dongCode, String year, String month) {
		return dao.gethomelist(dongCode, year, month);
	}

	@Override
	public ArrayList<HomeDto> getdeallist(String aptCode, String aptName) { 
		return dao.getdeallist(aptCode, aptName);
	}
	 

	
}
