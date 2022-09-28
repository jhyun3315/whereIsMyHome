package map.Service;

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
	public List<MapDto> selectmap(String sidoName, String gugunName, String dongName) throws Exception {
		
		List<MapDto> selectMember = dao.selectmap(sidoName, gugunName, dongName);
		return selectMember; 
	}

	@Override
	public List<String> sidoNamelist() { 
		return dao.sidoNamelist();
	}

	
	
}
