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
	 

	
}
