package map.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import map.dao.MapDao;
import map.dao.MapDaoImpl;
import map.dto.MapDto;

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
	public ArrayList<String> getsido() { 
		return dao.getsido();
	}

	@Override
	public ArrayList<String> getgugun(String sidoName) { 
		return dao.getgugun(sidoName);
	}

	@Override
	public ArrayList<String> getdong(String gugunName) { 
		return dao.getdong(gugunName);
	} 
	
}
